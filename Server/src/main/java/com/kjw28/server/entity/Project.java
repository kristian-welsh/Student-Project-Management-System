package com.kjw28.server.entity;

import com.kjw28.server.entity.dto.ProjectDTO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(name="findAllProjects",query="SELECT p FROM Project p"),
    @NamedQuery(name="findProjectById",query="SELECT p FROM Project p WHERE p.id=:id"),
    @NamedQuery(name="findAvailableProjects",query="SELECT p FROM Project p WHERE p.status = 'available'"),
    @NamedQuery(name="findProposedFromSupervisor",query="SELECT p FROM Project p WHERE p.supervisor.id = :supervisorId AND p.status='proposed'")
})
@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private List<String> skills;
    @NotNull
    private String status = "available";
    @NotNull
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "supervisorId")
    private Supervisor supervisor;
    @OneToOne(mappedBy = "project")
    private Student student;
    @NotNull
    @ManyToOne
    @JoinColumn
    private ProjectTopic topic;

    public Project() {
        // intentionally blank
    }

    public Project(ProjectDTO dto, Supervisor supervisor, ProjectTopic topic) {
        this.title = dto.title;
        this.description = dto.description;
        this.skills = dto.skills;
        this.status = dto.status;
        this.supervisor = supervisor;
        this.topic = topic;
    }

    public Project(String title, String description, List<String> skills, String status, Supervisor supervisor, ProjectTopic topic) {
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.status = status;
        this.supervisor = supervisor;
        this.topic = topic;
    }
    
    // todo: use dto instead
    public Project copyMock() {
        // todo: integrate topic as a string somehow
        Project mock = new Project();
        mock.setId(id);
        mock.setTitle(title);
        mock.setDescription(description);
        mock.setSkills(skills);
        mock.setStatus(status);
        ProjectTopic mockTopic = topic.copyMock();
        mock.setTopic(mockTopic);
        return mock;
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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ProjectTopic getTopic() {
        return topic;
    }

    public void setTopic(ProjectTopic topic) {
        this.topic = topic;
    }
    //</editor-fold>

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.title);
        hash = 43 * hash + Objects.hashCode(this.description);
        hash = 43 * hash + Objects.hashCode(this.skills);
        hash = 43 * hash + Objects.hashCode(this.status);
        hash = 43 * hash + Objects.hashCode(this.supervisor);
        hash = 43 * hash + Objects.hashCode(this.topic);
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
        final Project other = (Project) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.skills, other.skills)) {
            return false;
        }
        if (!Objects.equals(this.supervisor, other.supervisor)) {
            return false;
        }
        if (!Objects.equals(this.topic, other.topic)) {
            return false;
        }
        return true;
    }
}
