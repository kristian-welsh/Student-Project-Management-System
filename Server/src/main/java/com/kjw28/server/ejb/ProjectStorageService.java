package com.kjw28.server.ejb;

import java.util.List;
import com.kjw28.server.entity.Project;

public interface ProjectStorageService {
    List<Project> getFullProjectList();
    void insertProject(String title, String description, List<String> skills, String status);
}
