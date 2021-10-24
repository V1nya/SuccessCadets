package com.example.SuccessCadets.faculty;

import com.example.SuccessCadets.controls.MainControls;

import java.util.*;
import java.util.stream.Collectors;

public class Group {

   private int number;
   private List<Cadet> cadets= new ArrayList<Cadet>(){};
   private int middle_grade_of_group;
   private int progress_group;


   public Group(){}
    public Group(int number, int middle_grade_of_group) {
        this.number = number;
        this.middle_grade_of_group = middle_grade_of_group;

    }


    public int middle_gr_group(){
       int notes =0;
       for(int i=0; i<cadets.size(); i++){
           notes+=cadets.get(i).grade;
       }
       int middle = notes/cadets.size();
       return middle;
    }

    public List<Cadet> top_cadets(){

       List<Cadet> ca=  (List<Cadet>) cadets.stream().sorted((o1, o2) -> o2.getGrade()- o1.getGrade()).limit(15).collect(Collectors.toList());
       return ca;
    }


    public List<Cadet> getCadets() {
        return this.cadets;
    }

    public void setCadets(List<Cadet> cadets) {
        this.cadets = cadets;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMiddle_grade() {
        return middle_grade_of_group;
    }

    public void setMiddle_grade(int middle_grade) {
        this.middle_grade_of_group = middle_grade_of_group;
    }

    public int getProgress() {
        return progress_group;
    }

    public void setProgress(int progress) {
        this.progress_group = progress_group;
    }


}

