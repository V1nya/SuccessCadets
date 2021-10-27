package com.example.SuccessCadets.controls;

import com.example.SuccessCadets.servise.GoogleSheetsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
public class MainController {
GoogleSheetsServiceImpl googleSheetsService = new GoogleSheetsServiceImpl();
    @GetMapping("/")
    public String homePage(){

        return "homePage";
    }

    @GetMapping("/start")
    public void startProject() throws GeneralSecurityException, IOException {
        googleSheetsService.getSpreadsheetValues();
    }

}
