package com.kjw28.server.ejb.services;

import java.util.List;
import com.kjw28.server.entity.Project;

public interface ProjectStorageService {
    List<Project> getFullProjectList();
    List<Project> getAvailableProjectList();
    void insertProject(Project project);
    Project getProject(Long id);
    List<Project> getProposedProjectsForSupervisor(Long id);
}
