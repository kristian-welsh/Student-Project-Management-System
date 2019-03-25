package com.kjw28.server.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean {
    private String name;
    private String surname;
    private String department;
    private String email;
    private String phone;
    private String course;
    private String password;
    
    public RegisterBean() {
        
    }

    public RegisterBean(String name, String surname, String department, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }
    
    public String submitSupervisor() {
        // add supervisor to database etc here
        return "login";
    }
    
    public String submitStudent() {
        // add supervisor to database etc here
        return "login";
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
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
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>
}
