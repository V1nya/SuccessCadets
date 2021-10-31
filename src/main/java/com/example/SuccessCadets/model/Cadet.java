package com.example.SuccessCadets.model;

import javax.persistence.*;


@Entity
@Table(name = "cadets")
public class Cadet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

      private   String name,gr,course;
      private   double grade;
      private   int progress = 0;

    public Cadet() {
    }

    public Cadet(String name,String group,String course, double grade) {
        this.name = name;
        this.gr = group;
        this.course=course;
        this.grade = grade;
    }


    public String getGr() {
        return gr;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return gr;
    }

    public void setGroup(String group) {
        this.gr = group;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
