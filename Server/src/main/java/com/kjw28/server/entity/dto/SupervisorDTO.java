package com.kjw28.server.entity.dto;

import java.util.List;

public class SupervisorDTO {
    public Long id;
    public String name;
    public String surname;
    public String department;
    public String email;
    public String phone;
    public String password;
    public List<ProjectDTO> projects;

    public SupervisorDTO() {
        // intentionally blank
    }
    
    public SupervisorDTO(String name, String surname, String department, String email, String phone, String password) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
