package com.kjw28.server.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name="findAllStudents",query="SELECT s FROM Student s"),
    @NamedQuery(name="findStudentById",query="SELECT s FROM Student s WHERE s.id=:id")
})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String course;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Project project;

    public Student() {
        // intentionally blank
    }
    //https://vladmihalcea.com/the-best-way-to-use-entity-inheritance-with-jpa-and-hibernate/
    public Student(String name, String surname, String course, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.email = email;
        this.password = password;
    }
    
    public Student(String name, String surname, String course, String email, String password, Project project) {
        this(name, surname, course, email, password);
        this.project = project;
    }
    
    public Student copyMock() {
        Student mock = new Student();
        mock.setId(id);
        mock.setName(name);
        mock.setSurname(surname);
        mock.setCourse(course);
        mock.setEmail(email);
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    //</editor-fold>

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.surname);
        hash = 37 * hash + Objects.hashCode(this.course);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.password);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
