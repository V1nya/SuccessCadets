


package com.example.SuccessCadets.controls;


import com.example.SuccessCadets.faculty.Cadet;
import com.example.SuccessCadets.faculty.Course;
import com.example.SuccessCadets.faculty.Group;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainControls {


    @SneakyThrows
    @GetMapping("/")
    public String mainPage(Model model){

        List<Cadet> n_cadets =new ArrayList<Cadet>();
        n_cadets.add(201, new Cadet("Pusanka Kurulo", 5, 35 ));
        n_cadets.add(201, new Cadet("Turchak Olga", 4,27));
        n_cadets.add(201, new Cadet("Noshenko Alina", 2, 14 ));
        n_cadets.add(202, new Cadet("Grishenko Denis", 4, 31  ));
        n_cadets.add(202, new Cadet("Pusanka Kurulo", 5, 35 ));





        List<Group>gr = new ArrayList<Group>();
        gr.add(new Group(201, 35));
        gr.add(new Group(291, 43));
        gr.add(new Group(282, 31));
        gr.add(new Group(203, 34));
        gr.add(new Group(281, 30));
        gr.add(new Group(292, 40));

        Course c = new Course();
        System.out.println(c.top_group(gr));



            model.addAttribute("data","");

        return "/mainPage";
    }

}
