package com.kjw28.server.ejb;

import java.util.List;
import com.kjw28.server.entity.Project;

public interface ProjectStorageService {
    List<Project> getFullProjectList();
    List<Project> getAvailableProjectList();
    void insertProject(String title, String description, List<String> skills, String status,
            Long supervisorId, Long topicId);
    Project getProject(Long id);
}
