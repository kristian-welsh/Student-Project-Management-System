package com.kjw28.server.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name="findAllSupervisors",query="SELECT s FROM Supervisor s"),
    @NamedQuery(name="findSupervisorById",query="SELECT s FROM Supervisor s WHERE s.id=:id")
})
public class Supervisor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String department;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    private List<Project> projects;

    public Supervisor() {
        // intentionally blank
    }
    //https://vladmihalcea.com/the-best-way-to-use-entity-inheritance-with-jpa-and-hibernate/
    public Supervisor(String name, String surname, String department, String email, String phone, String password) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    
    public void addProject(Project p) {
        projects.add(p);
    }
    
    public Supervisor copyMock() {
        Supervisor mock = new Supervisor();
        mock.setId(id);
        mock.setName(name);
        mock.setSurname(surname);
        mock.setDepartment(department);
        mock.setEmail(email);
        mock.setPhone(phone);
        mock.setPassword(password);
        return mock;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    //</editor-fold>

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.surname);
        hash = 79 * hash + Objects.hashCode(this.department);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.projects);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supervisor other = (Supervisor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.department, other.department)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.projects, other.projects)) {
            return false;
        }
        return true;
    }
}
