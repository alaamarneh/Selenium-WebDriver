package com.ala;

public class Grade {
    private String grade;
    private int hours;

    public Grade(String grade, int hours) {
        this.grade = grade;
        this.hours = hours;
    }

    public String getGrade() {

        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
