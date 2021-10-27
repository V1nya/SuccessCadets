package com.example.SuccessCadets.controls;


import com.example.SuccessCadets.servise.GoogleSheetsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping()
public class GoogleSheetsController {

    @Autowired
    private GoogleSheetsServiceImpl googleSheetsService = new GoogleSheetsServiceImpl();


    @GetMapping("/")
    public String getSpreadsheetValues() throws IOException, GeneralSecurityException {
       googleSheetsService.getSpreadsheetValues();



//        return googleSheetsService.getSheetValues();
        return "OK";
    }

}
