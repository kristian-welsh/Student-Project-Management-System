package com.kjw28.server.entity.dto;

import com.kjw28.server.entity.Project;
import java.util.List;

// data transport object
// I may need to remove backreferences from these
public class ProjectDTO {
    public Long id;
    public String title;
    public String description;
    public List<String> skills;
    public String status = "available";
    public Long studentId;
    public Long supervisorId;
    public Long topicId;

    public ProjectDTO() {
        // intentionally blank
    }
    
    public ProjectDTO(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.skills = entity.getSkills();
        this.status = entity.getStatus();
        this.supervisorId = entity.getSupervisor().getId();
        this.topicId = entity.getTopic().getId();
    }

    public ProjectDTO(String title, String description, List<String> skills, String status, Long supervisorId, Long topicId) {
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.status = status;
        this.supervisorId = supervisorId;
        this.topicId = topicId;
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
    //</editor-fold>
}
