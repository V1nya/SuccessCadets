package com.example.SuccessCadets.controls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControls {

    @GetMapping("/")
    public String mainPage(Model model){


        return "mainPage";
    }

}
