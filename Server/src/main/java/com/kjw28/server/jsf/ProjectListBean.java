package com.kjw28.server.jsf;

import com.kjw28.server.entity.Project;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProjectListBean {
    // rename me to ProjectBean since I'm using this for things other than listing
    Project selectedProject;
    
    public ProjectListBean() {
        
    }

    public ArrayList<Project> getFullProjectList() {
        // todo: get list from ejb service backed by db
        return createTestList();
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
    
    
    
    // just for development purposes before database is setup:
    
    private ArrayList<Project> createTestList() {
        ArrayList<Project> list = new ArrayList<>();
        list.add(createTestProject());
        return list;
    }
    
    private Project createTestProject() {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("test skill");
        return new Project("test title", "test description", skills, "test status");
    }
}
