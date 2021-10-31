package com.example.SuccessCadets.logics;
import com.example.SuccessCadets.model.Cadet;
import com.example.SuccessCadets.model.TopCadets;
import com.example.SuccessCadets.repo.CadetRepository;
import com.example.SuccessCadets.repo.TopCadetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Start {
    @Autowired
    TopCadetsRepository topCadetsRepository;

    @Autowired
    CadetRepository cadetRepository;

    RestTemplate restTemplate = new RestTemplate();



    public void initTopCadet()  {
        topCadetsRepository.save(new TopCadets("name","v","27",7.5));
        var topCadetCourse= topCadetsRepository.findAll();
        var cadets = cadetRepository.findAll();

        List<Cadet> newTopCourse = new ArrayList<>();
        for (Cadet cad:cadets) {
            if (topCadetCourse.size()!=0){
               if (cad.getCourse().equals(SequenceOfCourses.getNextCourse(topCadetCourse.get(0).getCourse()))){
                   newTopCourse.add(cad);
               }
            }
            else {
                if (cad.getCourse()=="20" ){
                    newTopCourse.add(cad);
                }
            }
        }
        topCadetsRepository.deleteAll();
        topCadetCourse.stream().sorted((x,y)-> (int) (x.getGrade()- x.getGrade()));
        for (int i=0;i<21;i++) {
            topCadetsRepository.save(topCadetCourse.get(i));
        }
    }


}
