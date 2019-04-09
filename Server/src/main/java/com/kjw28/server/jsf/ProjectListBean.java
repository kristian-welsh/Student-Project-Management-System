package com.kjw28.server.jsf;

import com.kjw28.server.ejb.ProjectStorageService;
import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.ProjectTopic;
import com.kjw28.server.entity.Supervisor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProjectListBean {
    // rename me to ProjectBean since I'm using this for things other than listing
    Project selectedProject;
    List<Project> availableProjects;
    
    @EJB
    ProjectStorageService projectStore;
    
    public ProjectListBean() {
        
    }
    
    @PostConstruct
    public void loadData() {
        availableProjects = projectStore.getAvailableProjectList();
    }

    public List<Project> getAvailableProjectList() {
        return availableProjects;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }
    
    public String selectProject(Project project) {
        selectedProject = project; // save selection across post request
        return "project-information";
    }
    
    public String confirmSelection() {
        // todo: change project status and notify supervisor
        // do this, but on an ejb: selectedProject.setStatus("Proposed");
        return "selection-successful";
    }
    
    public ArrayList<Project> getMyProjectReviewList() {
        // todo: get list from ejb service backed by db
        // all awaiting review projects supervised by logged in supervisor
        return createTestList();
    }
    
    public String reviewProject(Project project) {
        selectedProject = project; // save selection across post request
        return "review-project";
    }
    
    public String acceptProposal() {
        // todo: do the thing (through ejb)
        return "review-selections";
    }
    
    public String rejectProposal() {
        // todo: do the thing (through ejb)
        return "review-selections";
    }
    
    // just for development purposes before database is setup:
    
    private ArrayList<Project> createTestList() {
        ArrayList<Project> list = new ArrayList<>();
        list.add(createTestProject());
        return list;
    }
    
    private Project createTestProject() {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("test skill");
        Supervisor supervisor = new Supervisor("Paul", "Newbury", "Informatics", "paul.newbury@sussex.ac.uk", "055501234", "password");
        ProjectTopic topic = new ProjectTopic("Neural Networks");
        return new Project("test title", "test description", skills, "test status", supervisor, topic);
    }
}
