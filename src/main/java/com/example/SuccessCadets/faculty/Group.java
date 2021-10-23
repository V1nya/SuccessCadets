package com.example.SuccessCadets.faculty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
   List<Cadet> cadets= new ArrayList<Cadet>();
   int number;
   int middle_grade_of_group;
   int progress_group;

    public Group(List<Cadet> cadets, int number, int middle_grade, int progress) {
        this.cadets = cadets;
        this.number = number;
        this.middle_grade_of_group = middle_grade_of_group;
        this.progress_group = progress_group;
    }

    public List<Cadet> getCadets() {
        return cadets;
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

