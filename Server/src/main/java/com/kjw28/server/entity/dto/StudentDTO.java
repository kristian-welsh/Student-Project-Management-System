package com.kjw28.server.entity.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    public Long id;
    public String name;
    public String surname;
    public String course;
    public String email;
    public String password;
    public ProjectDTO project;

    public StudentDTO() {
        // intentionally blank
    }
    
    public StudentDTO(String name, String surname, String course, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.email = email;
        this.password = password;
    }
    
    public StudentDTO(String name, String surname, String course, String email, String password, ProjectDTO project) {
        this(name, surname, course, email, password);
        this.project = project;
    }
}
