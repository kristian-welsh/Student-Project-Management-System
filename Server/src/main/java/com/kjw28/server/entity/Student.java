package com.kjw28.server.entity;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String course;
    private String email;
    private String password;

    public Student() {
        // intentionally blank
    }
    
    public Student(String name, String surname, String course, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.email = email;
        this.password = password;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>  
}
