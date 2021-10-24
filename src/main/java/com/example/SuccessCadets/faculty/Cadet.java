package com.example.SuccessCadets.faculty;

public class Cadet  {
    String name;
    int progress;
    int grade;

    public Cadet(){}
    public Cadet(String name, int progress, int grade) {
        this.name = name;
        this.progress = progress;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Cadet: " + name +
                ", progress: " + progress +
                ", grade: " + grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
