package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.config.GoogleAuthorizationConfig;
import com.example.SuccessCadets.faculty.Cadet;
import com.example.SuccessCadets.faculty.Course;
import com.example.SuccessCadets.faculty.Group;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleSheetsServiceImpl implements GoogleSheetsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSheetsServiceImpl.class);

    @Value("15lFfOpJUcCtQo8GkGGPw6RZKgtKdiLSDc-3dC4yuiIA")
    private String spreadsheetId;

    @Autowired
    private GoogleAuthorizationConfig googleAuthorizationConfig;

    @Override
    public Course getSpreadsheetValues() throws IOException, GeneralSecurityException {
        Sheets sheetsService = googleAuthorizationConfig.getSheetsService();
        Sheets.Spreadsheets.Values.BatchGet request =
                sheetsService.spreadsheets().values().batchGet(spreadsheetId);
        request.setRanges(getRange());
        BatchGetValuesResponse response = request.execute();
        Course course = new Course();
        List<Group> groups = new ArrayList<>();
        for (int i =0;i<response.size();i++){
            List<List<Object>> spreadSheetValues = response.getValueRanges().get(i).getValues();
            List<Cadet> cadets = new ArrayList<>();
            for (List<Object> cad:spreadSheetValues) {
                Cadet cadet = new Cadet((String) cad.get(0),Integer.parseInt((String)cad.get(1)));
                cadets.add(cadet);
            }
            groups.add(new Group(201,cadets));
        }
        course.setGroups(groups);
        course.setNum(20);
        List<List<Object>> spreadSheetValues = response.getValueRanges().get(1).getValues();

        int i =0;
        return course;
    }



    private List<String> getRange() throws IOException, GeneralSecurityException {
        List<String> res = new ArrayList<>();
        res.add("201!A2:B30");
        res.add("202!A2:B30");
        res.add("203!A2:B30");
        return res;
    }
}
