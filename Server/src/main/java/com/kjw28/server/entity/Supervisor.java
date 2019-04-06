package com.kjw28.server.entity;

public class Supervisor {
    private int id;
    private String name;
    private String surname;
    private String department;
    private String email;
    private String phone;
    private String password;

    public Supervisor() {
        // intentionally blank
    }
    
    public Supervisor(String name, String surname, String department, String email, String phone, String password) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.phone = phone;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>  
}
