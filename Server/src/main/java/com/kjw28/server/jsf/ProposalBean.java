package com.kjw28.server.jsf;

import com.kjw28.server.ejb.ProjectStorageService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class ProposalBean {
    private String title = "";
    private String description = "";
    private List<String> skills = new ArrayList<>();
    private String topic;
    private String supervisor;
    private String status;
    
    @EJB
    ProjectStorageService projectStore;

    public ProposalBean() {
        
    }

    public ProposalBean(List<String> skills, String status) {
        this.skills = skills;
        this.status = status;
    }
    
    public String submitStudentProposal() {
        status = "Proposed";
        // todo: stop submission if student has proposed project that hasn't
        //       been accepted yet (probably re-use current proposed)
        projectStore.insertProject(title, description, skills, status);
        return "proposal-confirmation";
    }
    
    public String submitSupervisorProposal() {
        status = "Available";
        // todo: grab currently logged in supervisor from context
        // todo: persist
        return "proposal-confirmation";
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<String> getTopics() {
        return mockTopics();
    }
    
    public List<String> getSupervisors() {
        return mockSupervisors();
    }
    
    //</editor-fold>
    
    // just for development purposes before database is setup:
    
    private List<String> mockTopics() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Natural Language Engineering");
        return list;
    }
    
    private List<String> mockSupervisors() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Dr. Paul Newbury");
        return list;
    }
}
