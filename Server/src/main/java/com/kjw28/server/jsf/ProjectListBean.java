package com.kjw28.server.jsf;

import com.kjw28.server.ejb.ProjectListLogic;
import com.kjw28.server.entity.dto.ProjectDTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// todo: now that the logic is speprated, i can create seperate jsf beans for student and supervisor project lists
@Named
@RequestScoped
public class ProjectListBean implements Serializable {
    // rename me to ProjectBean since I'm using this for things other than listing
    @EJB
    ProjectListLogic logic;

    public List<ProjectDTO> getAvailableProjectList() {
        return logic.getAvailableProjects();
    }

    public ProjectDTO getSelectedProject() {
        return logic.getSelectedProject();
    }
    
    public String selectProject(ProjectDTO project) {
        logic.selectProject(project);
        return "project-information";
    }
    
    public String confirmSelection() {
        logic.confirmProjectSelection();
        return "selection-successful";
    }
    
    public List<ProjectDTO> getMyProjectReviewList() {
        // todo: get supervisor ID from loged in user info
        Long supervisorId = 1l;
        System.out.println("list fetched");
        return logic.getReviewList(supervisorId);
    }
    
    public String reviewProject(ProjectDTO project) {
        logic.selectProject(project);
        return "review-project";
    }
    
    public String acceptProposal() {
        logic.acceptSelection();
        return "review-selections";
    }
    
    public String rejectProposal() {
        logic.rejectSelection();
        return "review-selections";
    }
}
