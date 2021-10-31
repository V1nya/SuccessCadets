package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.config.GoogleAuthorizationConfig;
import com.example.SuccessCadets.logics.SequenceOfCourses;
import com.example.SuccessCadets.model.Cadet;
import com.example.SuccessCadets.model.TopCadets;
import com.example.SuccessCadets.repo.CadetRepository;
import com.example.SuccessCadets.repo.TopCadetsRepository;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleSheetsServiceImpl implements GoogleSheetsService {

    private String[] listInSheet = new String[]{"201","202","203"};

    @Value("15lFfOpJUcCtQo8GkGGPw6RZKgtKdiLSDc-3dC4yuiIA")
    private String spreadsheetId;

    @Autowired
    private GoogleAuthorizationConfig googleAuthorizationConfig;

    @Autowired
    private CadetRepository cadetRepository;

    @Autowired
    TopCadetsRepository topCadetsRepository;

    public void initTopCadet()  {
        topCadetsRepository.deleteAll();
       topCadetsRepository.save(new TopCadets("name","v","21",7.5));
        var topCadetCourse= topCadetsRepository.findAll();
        var cadets = cadetRepository.findAll();

        List<Cadet> newTopCourse = new ArrayList<>();
        for (Cadet cad:cadets) {
            if (topCadetCourse.size()!=0){
                String nextCourse =SequenceOfCourses.getNextCourse(topCadetCourse.get(0).getCourse());
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
        for (int i=0;i<20;i++) {
            TopCadets topCadets = new TopCadets();
            topCadets.setName(newTopCourse.get(i).getName());
            topCadets.setGr(newTopCourse.get(i).getGroup());
            topCadets.setCourse(newTopCourse.get(i).getCourse());
            topCadets.setGrade(newTopCourse.get(i).getGrade());
            topCadetsRepository.save(topCadets);
        }
    }

    @Override
    public void getSpreadsheetValues() throws IOException, GeneralSecurityException {
        Sheets sheetsService = googleAuthorizationConfig.getSheetsService();
        Sheets.Spreadsheets.Values.BatchGet request =
                sheetsService.spreadsheets().values().batchGet(spreadsheetId);
        request.setRanges(getRange());
        BatchGetValuesResponse response = request.execute();

        for (int i = 0 ;i<response.size()+1;i++) {
            List<List<Object>> spreadSheetValues = response.getValueRanges().get(i).getValues();
            for (List<Object> cad:spreadSheetValues) {
                if(cad.get(1)!=null) {
                    Cadet cadet = new Cadet((String) cad.get(0),listInSheet[i],listInSheet[i].substring(0,listInSheet.length-1), parseDouble((String) cad.get(1)));
                    cadetRepository.save(cadet);
                }
            }
        }



//        List<Course> courses = new ArrayList<>();
//        List<Group> groups = new ArrayList<>();
//        for (int i =0;i<response.size()+1;i++){
//            List<List<Object>> spreadSheetValues = response.getValueRanges().get(i).getValues();
//            List<Cadet> cadets = new ArrayList<>();
//            for (List<Object> cad:spreadSheetValues) {
//                if(cad.get(1)!=null) {
//                    Cadet cadet = new Cadet((String) cad.get(0),parseDouble((String) cad.get(1)));
//                    cadets.add(cadet);
//                }
//            }
//            if (response.size()>=i+1 && !listInSheet[i+1].substring(0,listInSheet[i+1].length()-1).equals( listInSheet[i].substring(0,listInSheet.length-1))){
//                groups.add(new Group(Integer.parseInt(listInSheet[i]), cadets));
//                List<Group> groupss = new ArrayList<>();
//                for (Group gr:groups
//                     ) {
//                    groupss.add(gr);
//
//                }
//                courses.add(new Course(groupss,listInSheet[i].substring(0,listInSheet.length-1)));
//                groups.clear();
//            }else if (i==response.size()){
//                groups.add(new Group(Integer.parseInt(listInSheet[i]), cadets));
//                List<Group> groupss = new ArrayList<>();
//                for (Group gr:groups
//                ) {
//                    groupss.add(gr);
//
//                }
//                courses.add(new Course(groupss,listInSheet[i].substring(0,listInSheet.length-1)));
//                groups.clear();
//            }
//            else{
//                groups.add(new Group(Integer.parseInt(listInSheet[i]), cadets));
//            }
//        }
//
//        int i=0;
//        return courses;
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
