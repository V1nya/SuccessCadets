package com.example.SuccessCadets.model;


import javax.persistence.*;


@Entity
@Table(name = "LoadCadetsWeek")
public class CadetsWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private   String name,gr,course;
    private   double grade;
    private   int startPosition = 0;

    public CadetsWeek() {
    }

    public CadetsWeek(String name, String group, String course, double grade) {
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

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}

