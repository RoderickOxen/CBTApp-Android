package com.cbt.cbtapp.models;

import android.graphics.Bitmap;

public class Candidate{

    private String candidate_id;
    private String candidate_title;
    private String candidate_academic;
    private String candidate_keyowrds;
    private String candidate_motivation;
    private String candidate_industries;
    private String candidate_residence;
    private String candidate_salary;
    private String candidate_experience;
    private String candidate_nationality;
    private Bitmap candidate_image;



    public Candidate(String candidate_id, String candidate_title,String candidate_academic, String candidate_keyowrds, String candidate_motivation, String candidate_industries, String candidate_residence, String candidate_salary, String candidate_experience, String candidate_nationality,Bitmap candidate_image) {
        this.candidate_id = candidate_id;
        this.candidate_title = candidate_title;
        this.candidate_academic = candidate_academic;
        this.candidate_keyowrds = candidate_keyowrds;
        this.candidate_motivation = candidate_motivation;
        this.candidate_industries = candidate_industries;
        this.candidate_residence = candidate_residence;
        this.candidate_salary = candidate_salary;
        this.candidate_experience = candidate_experience;
        this.candidate_nationality = candidate_nationality;
        this.candidate_image = candidate_image;
    }

    public String getCandidate_nationality() {
        return candidate_nationality;
    }

    public void setCandidate_nationality(String candidate_nationality) {
        this.candidate_nationality = candidate_nationality;
    }

    public Bitmap getCandidate_image() {
        return candidate_image;
    }

    public void setCandidate_image(Bitmap candidate_image) {
        this.candidate_image = candidate_image;
    }

    public String getCandidate_title() {
        return candidate_title;
    }

    public void setCandidate_title(String candidate_title) {
        this.candidate_title = candidate_title;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getCandidate_academic() {
        return candidate_academic;
    }

    public void setCandidate_academic(String candidate_academic) {
        this.candidate_academic = candidate_academic;
    }

    public String getCandidate_keyowrds() {
        return candidate_keyowrds;
    }

    public void setCandidate_keyowrds(String candidate_keyowrds) {
        this.candidate_keyowrds = candidate_keyowrds;
    }

    public String getCandidate_motivation() {
        return candidate_motivation;
    }

    public void setCandidate_motivation(String candidate_motivation) {
        this.candidate_motivation = candidate_motivation;
    }

    public String getCandidate_industries() {
        return candidate_industries;
    }

    public void setCandidate_industries(String candidate_industries) {
        this.candidate_industries = candidate_industries;
    }

    public String getCandidate_residence() {
        return candidate_residence;
    }

    public void setCandidate_residence(String candidate_residence) {
        this.candidate_residence = candidate_residence;
    }

    public String getCandidate_salary() {
        return candidate_salary;
    }

    public void setCandidate_salary(String candidate_salary) {
        this.candidate_salary = candidate_salary;
    }

    public String getCandidate_experience() {
        return candidate_experience;
    }

    public void setCandidate_experience(String candidate_experience) {
        this.candidate_experience = candidate_experience;
    }
}
