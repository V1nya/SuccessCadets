package com.example.SuccessCadets.faculty;

import java.util.ArrayList;
import java.util.List;

public class Course {
    List<Group> groups = new ArrayList<Group>();
    int num;
    int middle_grade_of_course;
    int progress_course;
    

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

    public Course(List<Group> groups, int num, int middle_grade_of_course, int progress_course) {
        this.groups = groups;
        this.num = num;
        this.middle_grade_of_course = middle_grade_of_course;
        this.progress_course = progress_course;
    }
}
