package com.kjw28.server.ejb;

import com.kjw28.server.entity.dto.ProjectDTO;
import java.util.List;

public interface ProjectListLogic {
    public List<ProjectDTO> getAvailableProjects();
    // assigns a project to a student
    public void selectProject(ProjectDTO selectedProject);
    public ProjectDTO getSelectedProject();
    public void confirmProjectSelection();
    public void acceptSelection();
    public void rejectSelection();
    public List<ProjectDTO> getReviewList(Long supervisorId);
}
