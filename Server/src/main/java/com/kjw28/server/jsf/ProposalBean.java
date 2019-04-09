package com.kjw28.server.jsf;

import com.kjw28.server.ejb.ProjectStorageService;
import com.kjw28.server.ejb.SupervisorStorageService;
import com.kjw28.server.entity.Supervisor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    // I can't use <String, Supervisor> because then i would have problems with transaction scopes.
    private HashMap<String, Long> supervisorIds;
    
    @EJB
    ProjectStorageService projectStore;
    @EJB
    SupervisorStorageService supervisorStore;

    public ProposalBean() {
        supervisorIds = new HashMap<>();
    }
    
    @PostConstruct
    public void loadSupervisors() {
        List<Supervisor> supervisors = supervisorStore.getFullSupervisorList();
        for (Supervisor s : supervisors)
            supervisorIds.put(s.getName() + " " + s.getSurname(), s.getId());
    }

    public ProposalBean(List<String> skills, String status) {
        this.skills = skills;
        this.status = status;
    }
    
    public String submitStudentProposal() {
        /* todo: implement logic in an ejb:
         * - stop submission if student has proposed project that hasn't
         *       been accepted yet (probably re-use current proposed)
         * - get logged in student and set project on them to be the created project
         */
        status = "Proposed";
        projectStore.insertProject(title, description, skills, status, supervisorIds.get(supervisor));
        return "proposal-confirmation";
    }
    
    public String submitSupervisorProposal() {
        /* todo: implement logic in an ejb:
         * - grab currently logged in supervisor from context
         * - persist
         */
        status = "Available";
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
    
    //</editor-fold>
    
    public List<String> getSupervisors() {
        return new ArrayList<>(supervisorIds.keySet());
    }
    
    // just for development purposes before database is setup:
    
    private List<String> mockTopics() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Natural Language Engineering");
        return list;
    }
}
