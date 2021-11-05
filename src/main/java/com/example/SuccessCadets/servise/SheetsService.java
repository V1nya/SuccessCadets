package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.config.GoogleAuthorizationConfig;
import com.example.SuccessCadets.model.Cadet;
import com.example.SuccessCadets.model.CadetsWeek;
import com.example.SuccessCadets.model.TopCadets;
import com.example.SuccessCadets.repo.CadetRepository;
import com.example.SuccessCadets.repo.CadetsWeekRepository;
import com.example.SuccessCadets.repo.TopCadetsRepository;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SheetsService implements GoogleSheetsService {

    private String[] listInSheet = new String[]{"201","212","293"};

    @Value("15lFfOpJUcCtQo8GkGGPw6RZKgtKdiLSDc-3dC4yuiIA")
    private String spreadsheetId;

    @Autowired
    private GoogleAuthorizationConfig googleAuthorizationConfig ;

    @Autowired
    private CadetRepository cadetRepository;

    @Autowired
    private TopCadetsRepository topCadetsRepository;

    @Autowired
    private CadetsWeekRepository cadetsWeekRepository;

    public void initTopCadet()  {
       topCadetsRepository.save(new TopCadets("name","v","21",7.5));
        var topCadetCourse= topCadetsRepository.findAll();
        var cadets = cadetRepository.findAll();

        List<Cadet> newTopCourse = new ArrayList<>();
        for (Cadet cad:cadets) {
            if (topCadetCourse.size()!=0){
                String nextCourse =getNextCourse(topCadetCourse.get(0).getCourse());
               if (cad.getCourse().equals(nextCourse)){
                    newTopCourse.add(cad);
                }
            }
            else {
                if (cad.getCourse().equals("20") ){
                    newTopCourse.add(cad);
                }
            }
        }
        topCadetsRepository.deleteAll();

        newTopCourse.sort((x,y)-> (int) (y.getGrade()*100-x.getGrade()*100));
        for (int i=0;i<newTopCourse.size();i++) {
            TopCadets topCadets = new TopCadets();
            topCadets.setName(newTopCourse.get(i).getName());
            topCadets.setGr(newTopCourse.get(i).getGroup());
            topCadets.setCourse(newTopCourse.get(i).getCourse());
            topCadets.setGrade(newTopCourse.get(i).getGrade());
            topCadets.setProgress(newTopCourse.get(i).getPosition());
            topCadetsRepository.save(topCadets);
        }
    }

    @Override
    public void setCadetsBD() throws IOException, GeneralSecurityException {
        cadetRepository.deleteAll();
        Sheets sheetsService = googleAuthorizationConfig.getSheetsService();
        Sheets.Spreadsheets.Values.BatchGet request =
                sheetsService.spreadsheets().values().batchGet(spreadsheetId);
        request.setRanges(getRange());
        BatchGetValuesResponse response = request.execute();

//        setWeekCadets(response);


        java.util.Map<String,List<Cadet>> map = new HashMap<String, List<Cadet>>();
        for (String course:listInSheet ) {
            String str = course.substring(0,2);
            if (!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
        }


        for (int i = 0 ;i<response.size()+1;i++) {
            List<List<Object>> spreadSheetValues = response.getValueRanges().get(i).getValues();
            for (List<Object> cad:spreadSheetValues) {
                if(cad.get(1)!=null) {
                    Cadet cadet = new Cadet((String) cad.get(0),listInSheet[i],listInSheet[i].substring(0,listInSheet.length-1), parseDouble((String) cad.get(1)));
                    List<Cadet> weekList = map.get(cadet.getCourse().substring(0,2));
                    weekList.add(cadet);
                    map.put(cadet.getCourse().substring(0,2),weekList);
                }
            }
        }

        var weekCadet = cadetsWeekRepository.findAll();

        for (String key:map.keySet()) {
            map.get(key).sort((x, y) -> (int) (y.getGrade() * 100 - x.getGrade() * 100));
            int i = 1;
            for (Cadet cadet :map.get(key)) {
                cadet.setPosition(i);
                i++;
                for (CadetsWeek weekCad:weekCadet) {

                    if (weekCad.getName().equals(cadet.getName())){
                        cadet.setPosition(weekCad.getStartPosition()-cadet.getPosition());
                        cadetRepository.save(cadet);
                        break;
                    }
                }
            }
        }



    }



    public void setWeekCadets(BatchGetValuesResponse response){


        java.util.Map<String,List<CadetsWeek>> map = new HashMap<String, List<CadetsWeek>>();
        for (String course:listInSheet ) {
            String str = course.substring(0,2);
            if (!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
        }


        for (int i = 0 ;i<response.size()+1;i++) {
            List<List<Object>> spreadSheetValues = response.getValueRanges().get(i).getValues();
            for (List<Object> cad:spreadSheetValues) {
                if(cad.get(1)!=null) {
                    CadetsWeek cadet = new CadetsWeek((String) cad.get(0),listInSheet[i],listInSheet[i].substring(0,listInSheet.length-1), parseDouble((String) cad.get(1)));
                    List<CadetsWeek> weekList = map.get(cadet.getCourse().substring(0,2));
                    weekList.add(cadet);
                    map.put(cadet.getCourse().substring(0,2),weekList);
                }
            }
        }
        for (String key:map.keySet()) {
            map.get(key).sort((x, y) -> (int) (y.getGrade() * 100 - x.getGrade() * 100));
            int i = 1;
            for (CadetsWeek cadetWeek :map.get(key)) {
                cadetWeek.setStartPosition(i);
                i++;
                cadetsWeekRepository.save(cadetWeek);
            }
        }
    }

    public  String getNextCourse(String course) {
        List<String> sequence = new ArrayList<>();
        for (String str :listInSheet) {
            String curs = str.substring(0,2);
            int i =0;
            for (String sht:sequence) {
                if (sht.equals(curs)){
                    i++;
                }
            }
            if (i==0){
                sequence.add(curs);
            }
        }

        for (int i = 0;i<sequence.size();i++) {
            if (i+1== sequence.size()){
                return sequence.get(0);
            }
            else {
                if (sequence.get(i).equals(course)){
                    return sequence.get(i+1);
                }
            }
        }
        return "20";
    }
    private double parseDouble(String text){
        String newStr = "";
        var chars = text.toCharArray();
        for (char ch:chars) {
            if (ch==',')
                newStr+='.';
            else
                newStr+=ch;
        }

        return Double.parseDouble(newStr);
    }

    private List<String> getRange() throws IOException, GeneralSecurityException {
        List<String> res = new ArrayList<>();
        for (String group:listInSheet
             ) {

        res.add(group+"!A2:B30");
        }
        return res;
    }
}
