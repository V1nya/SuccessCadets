package com.example.SuccessCadets.controls;

import com.example.SuccessCadets.faculty.Cadet;
import com.example.SuccessCadets.faculty.Group;
import com.example.SuccessCadets.readExcel.ReadExcel;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainControls {
ReadExcel readExcel = new ReadExcel();
Group group = new Group();
    @SneakyThrows
    @GetMapping("/")
    public String mainPage(Model model){

        List<Group> groups = new ArrayList<Group>(){};
        groups.add(201, 45);


        List<Cadet> cadets= new ArrayList<Cadet>(){};
        cadets.add(new Cadet("Turchak Olga", 5, 27 ));
        cadets.add(new Cadet("Pysanka Kiril", 8, 35 ));
        cadets.add(new Cadet("Noshenko Alina", 2, 12 ));
        cadets.add(new Cadet("Litvinenko Yarik", 5, 17 ));
        cadets.add(new Cadet("Sementsov Yevgenii", 5, 20 ));
        group.setCadets(cadets);
        List<Cadet> s = group.top_cadets();
        String g="";
        for (Cadet cad:s
             ) {
            g=g+cad.toString()+ "\n";
        }
        int k = 0;
         model.addAttribute("data",g);
        return "/mainPage";
    }

}
