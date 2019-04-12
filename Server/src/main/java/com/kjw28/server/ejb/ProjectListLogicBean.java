package com.kjw28.server.ejb;

import com.kjw28.server.ejb.services.ProjectStorageService;
import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.dto.ProjectDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// todo: look at how this behaves with multiple users viewing projects at the same time
@Stateless
public class ProjectListLogicBean implements ProjectListLogic {
    @EJB
    ProjectStorageService projectStore;
    
    @PersistenceContext EntityManager em;
    
    ProjectDTO selectedDTO;
    
    @Override
    public List<ProjectDTO> getAvailableProjects() {
        return toDTO(projectStore.getAvailableProjectList());
    }
    
    private List<ProjectDTO> toDTO(List<Project> projects) {
        List<ProjectDTO> dtos = new ArrayList<>();
        for (Project project : projects)
            dtos.add(new ProjectDTO(project));
        return dtos;
    }

    @Override
    public void selectProject(ProjectDTO selectedDTO) {
        this.selectedDTO = selectedDTO;
    }
    
    @Override
    public ProjectDTO getSelectedProject() {
        return selectedDTO;
    }

    @Override
    public void confirmProjectSelection() {
        // todo: get student user from context and assign to them
        //loggedInStudent.setProject(selectedProject);
        setSelectedStatus("proposed");
    }

    @Override
    public void acceptSelection() {
        setSelectedStatus("accepted");
    }

    @Override
    public void rejectSelection() {
        Project projectEntity = getSelectedEntity();
        // currently crashes because projects dont have students because logging in isn't supported yet
        projectEntity.getStudent().setProject(null);
        projectEntity.setStudent(null);
        projectEntity.setStatus("available");
    }
    
    private void setSelectedStatus(String status) {
        getSelectedEntity().setStatus(status);
    }
    
    private Project getSelectedEntity() {
        return projectStore.getProject(selectedDTO.id);
    }

    /** get proposed projects supervised by a specific supervisor
     * @param supervisorId
     * @return valid projects
     */
    @Override
    public List<ProjectDTO> getReviewList(Long supervisorId) {
        List<Project> entities = projectStore.getProposedProjectsForSupervisor(supervisorId);
        return toDTO(entities);
    }
}
