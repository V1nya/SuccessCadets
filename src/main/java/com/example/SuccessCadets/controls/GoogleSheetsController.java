//package com.example.SuccessCadets.controls;
//
//
//import com.example.SuccessCadets.servise.GoogleSheetsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//
//@Controller
//@RequestMapping()
//public class GoogleSheetsController {
//
//    @Autowired
//    private GoogleSheetsServiceImpl googleSheetsService = new GoogleSheetsServiceImpl();
//
//
//    @GetMapping("/")
//    public String getSpreadsheetValues(Model model) throws IOException, GeneralSecurityException {
//       var s = googleSheetsService.getSpreadsheetValues();
//
//        int k = 0;
//
//        return "page";
//    }
//
//}
