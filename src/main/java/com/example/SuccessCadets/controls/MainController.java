package com.example.SuccessCadets.controls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class MainController {
    int i = 0 ;

    public MainController() {
    }

    @GetMapping("/")
    public String homePage(){

        return "homePage";
    }
    @GetMapping("/getCadet")
    public String topCadet(Model model){
        this.i++;
        model.addAttribute("data", LocalDateTime.now());
        int i = 0;
        return "page";
    }





}
