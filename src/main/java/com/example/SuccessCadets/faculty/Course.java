package com.example.SuccessCadets.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    List<Group> groups = new ArrayList<Group>();
    int num;
    double middle_grade_of_course;
    double progress_course;



    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMiddle_grade_of_course() {
        return middle_grade_of_course;
    }

    public void setMiddle_grade_of_course(double middle_grade_of_course) {
        this.middle_grade_of_course = middle_grade_of_course;
    }

    public double getProgress_course() {
        return progress_course;
    }

    public void setProgress_course(double progress_course) {
        this.progress_course = progress_course;
    }
    public Course(){}
    public Course(List<Group> groups, int num ) {
        this.groups = groups;
        this.num = num;
    }
    public int middle_gr_course(){
        int notes =0;
        for(int i=0; i<groups.size(); i++){
            notes+=groups.get(i).middle_gr_group();
        }
        int middle = notes/groups.size();
        return middle;
    }

    public List<Group> top_group(List<Group> groups){

        List<Group> groups1 =  (List<Group>)groups.stream().sorted((o1, o2) -> (int) (o2.getMiddle_grade()- o1.getMiddle_grade())).limit(5).collect(Collectors.toList());
        return groups1;
    }
}
