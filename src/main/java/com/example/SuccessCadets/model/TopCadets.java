package com.example.SuccessCadets.model;

import javax.persistence.*;

@Entity
@Table(name = "top_cadet")
public class TopCadets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_top;
    private String name,gr,course;
    private double grade;
    private int progress = 0;

    public TopCadets(){}

    public TopCadets(String name, String gr, String course, double grade) {
        this.name = name;
        this.gr = gr;
        this.course = course;
        this.grade = grade;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGr() {
        return gr;
    }

    public void setGr(String gr) {
        this.gr = gr;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public Long getId() {
        return id_top;
    }

}
