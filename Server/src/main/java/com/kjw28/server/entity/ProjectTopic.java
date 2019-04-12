package com.kjw28.server.entity;

import com.kjw28.server.entity.dto.ProjectTopicDTO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name="findAllTopics",query="SELECT t FROM ProjectTopic t"),
    @NamedQuery(name="findTopicById",query="SELECT t FROM ProjectTopic t WHERE t.id=:id")
})
public class ProjectTopic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String title;
    @OneToMany(mappedBy = "topic")
    private List<Project> projects;

    public ProjectTopic() {
        // intentionally blank
    }

    public ProjectTopic(ProjectTopicDTO topic) {
        this.title = topic.title;
    }

    public ProjectTopic(String title) {
        this.title = title;
    }
    
    public void addProject(Project project) {
        projects.add(project);
    }
    
    public ProjectTopic copyMock() {
        return new ProjectTopic(title);
    }
    
    public ProjectTopicDTO toDTO() {
        return new ProjectTopicDTO(title);
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.title);
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
        final ProjectTopic other = (ProjectTopic) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
