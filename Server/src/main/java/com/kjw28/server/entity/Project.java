package com.kjw28.server.entity;

import java.util.ArrayList;

public class Project {
    private String title;
    private String description;
    private ArrayList<String> skills;
    private String status;

    public Project() {
    }

    public Project(String title, String description, ArrayList<String> skills, String status) {
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.status = status;
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">  
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //</editor-fold>  
}
