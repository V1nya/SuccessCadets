package com.example.SuccessCadets.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    List<Group> groups = new ArrayList<Group>();
    int num;
    int middle_grade_of_course;
    int progress_course;
    

    public List<Group> top_group(){

        List<Group> groups1 =  (List<Group>)groups.stream().sorted((o1, o2) -> o2.getMiddle_grade()- o1.getMiddle_grade()).limit(5).collect(Collectors.toList());
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

    public int getMiddle_grade_of_course() {
        return middle_grade_of_course;
    }

    public void setMiddle_grade_of_course(int middle_grade_of_course) {
        this.middle_grade_of_course = middle_grade_of_course;
    }

    public int getProgress_course() {
        return progress_course;
    }

    public void setProgress_course(int progress_course) {
        this.progress_course = progress_course;
    }
    public Course(){}
    public Course(List<Group> groups, int num, int middle_grade_of_course, int progress_course) {
        this.groups = groups;
        this.num = num;
        this.middle_grade_of_course = middle_grade_of_course;
        this.progress_course = progress_course;
    }
}
