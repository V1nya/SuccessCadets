package com.example.SuccessCadets.faculty;

public class Cadet {
    String name;
    int progress;
    double grade;

    public Cadet() {
    }

    public Cadet(String name, int progress, double grade) {
        this.name = name;
        this.progress = progress;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
