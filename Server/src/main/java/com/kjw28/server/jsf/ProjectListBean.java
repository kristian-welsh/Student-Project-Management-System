package com.kjw28.server.jsf;

import com.kjw28.server.entity.Project;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProjectListBean {
    
    public ProjectListBean() {
        
    }

    public ArrayList<Project> getFullProjectList() {
        // todo: get list from ejb service backed by db
        return createTestList();
    }
    
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
