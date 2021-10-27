package com.example.SuccessCadets.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    List<Group> groups = new ArrayList<Group>();
    int num;
    double middle_grade_of_course;
    double progress_course;
    

    public List<Group> top_group(List<Group> groups){

        List<Group> groups1 =  (List<Group>)groups.stream().sorted((o1, o2) -> o2.middle_gr_group()- o1.middle_gr_group()).limit(5).collect(Collectors.toList());
        return groups1;
    }
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
    public Course(List<Group> groups, int num, double middle_grade_of_course, double progress_course) {
        this.groups = groups;
        this.num = num;
        this.middle_grade_of_course = middle_grade_of_course;
        this.progress_course = progress_course;
    }
}
