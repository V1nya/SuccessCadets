package com.example.SuccessCadets.controls;


import com.example.SuccessCadets.servise.SheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping()
public class InitializationController {

    @Autowired
    private SheetsService googleSheetsService = new SheetsService();


    @GetMapping("/start")
    public String startProject() throws GeneralSecurityException, IOException {
//        googleSheetsService.getSpreadsheetValues();

//        googleSheetsService.initTopCadet();
        return "OK";
    }

}
