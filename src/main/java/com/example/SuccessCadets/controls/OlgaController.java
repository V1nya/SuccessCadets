package com.example.SuccessCadets.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OlgaController {
    @GetMapping("/cadet")
    public String cadet(){return "index";}
}
