package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.config.GoogleAuthorizationConfig;
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
    public void getSpreadsheetValues() throws IOException, GeneralSecurityException {
        Sheets sheetsService = googleAuthorizationConfig.getSheetsService();
        Sheets.Spreadsheets.Values.BatchGet request =
                sheetsService.spreadsheets().values().batchGet(spreadsheetId);
        request.setRanges(getSpreadSheetRange());
        BatchGetValuesResponse response = request.execute();
        List<List<Object>> spreadSheetValues = response.getValueRanges().get(1).getValues();
        int k=0;

    }

    @Override
    public String getSheetValues() throws IOException, GeneralSecurityException {
        String res ="+";
        int k=1;
        Sheets sheetsService = googleAuthorizationConfig.getSheetsService();
        Sheets.Spreadsheets.Values.BatchGet request =
                sheetsService.spreadsheets().values().batchGet(spreadsheetId);
        request.setRanges(getSpreadSheetRange());
//        request.setMajorDimension("COLUMNS");
        BatchGetValuesResponse response = request.execute();
        List<List<Object>> spreadSheetValues = response.getValueRanges().get(1).getValues();
        List<Object> headers = spreadSheetValues.remove(0);
        k=0;
        return (String) headers.get(0);
    }

    private List<String> getSpreadSheetRange() throws IOException, GeneralSecurityException {
        List<String> res = new ArrayList<>();
        res.add("201!A2:B30");
        res.add("202!A2:B30");
        res.add("203!A2:B30");
        return res;
    }
}
