package com.example.SuccessCadets.controls;


import com.example.SuccessCadets.repo.TopCadetsRepository;
import com.example.SuccessCadets.servise.SheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping()
public class InitializationController {

    @Autowired
    private SheetsService googleSheetsService = new SheetsService();

    @Autowired
    TopCadetsRepository topCadetsRepository;


    @GetMapping("/")
    public String topCadet(Model model) throws GeneralSecurityException, IOException {
//        googleSheetsService.getSpreadsheetValues();

        googleSheetsService.initTopCadet();

        var cadets = topCadetsRepository.findAll();
        model.addAttribute("cadets", cadets);
        model.addAttribute("course",cadets.get(0).getCourse());
        return "tableTop";
    }

    @GetMapping("/test")
    public String startProject() throws GeneralSecurityException, IOException {

        googleSheetsService.initTopCadet();
        return "OK";
    }

}
