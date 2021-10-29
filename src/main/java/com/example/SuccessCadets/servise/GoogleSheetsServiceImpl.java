package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.config.GoogleAuthorizationConfig;
import com.example.SuccessCadets.faculty.Cadet;
import com.example.SuccessCadets.faculty.Course;
import com.example.SuccessCadets.faculty.Group;
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

    @Override
    public List<Course> getSpreadsheetValues() throws IOException, GeneralSecurityException {
        Sheets sheetsService = googleAuthorizationConfig.getSheetsService();
        Sheets.Spreadsheets.Values.BatchGet request =
                sheetsService.spreadsheets().values().batchGet(spreadsheetId);
        request.setRanges(getRange());
        BatchGetValuesResponse response = request.execute();
        List<Course> courses = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        for (int i =0;i<response.size()+1;i++){
            List<List<Object>> spreadSheetValues = response.getValueRanges().get(i).getValues();
            List<Cadet> cadets = new ArrayList<>();
            for (List<Object> cad:spreadSheetValues) {
                if(cad.get(1)!=null) {
                    Cadet cadet = new Cadet((String) cad.get(0),parseDouble((String) cad.get(1)));
                    cadets.add(cadet);
                }
            }
            if (response.size()>=i+1 && !listInSheet[i+1].substring(0,listInSheet[i+1].length()-1).equals( listInSheet[i].substring(0,listInSheet.length-1))){
                groups.add(new Group(Integer.parseInt(listInSheet[i]), cadets));
                List<Group> groupss = new ArrayList<>();
                for (Group gr:groups
                     ) {
                    groupss.add(gr);

                }
                courses.add(new Course(groupss,listInSheet[i].substring(0,listInSheet.length-1)));
                groups.clear();
            }else if (i==response.size()){
                groups.add(new Group(Integer.parseInt(listInSheet[i]), cadets));
                List<Group> groupss = new ArrayList<>();
                for (Group gr:groups
                ) {
                    groupss.add(gr);

                }
                courses.add(new Course(groupss,listInSheet[i].substring(0,listInSheet.length-1)));
                groups.clear();
            }
            else{
                groups.add(new Group(Integer.parseInt(listInSheet[i]), cadets));
            }
        }

        int i=0;
        return courses;
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
