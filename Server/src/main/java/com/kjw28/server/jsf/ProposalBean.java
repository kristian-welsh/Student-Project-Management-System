package com.kjw28.server.jsf;

import com.kjw28.server.ejb.ProjectStorageService;
import com.kjw28.server.ejb.SupervisorStorageService;
import com.kjw28.server.ejb.TopicStorageService;
import com.kjw28.server.entity.ProjectTopic;
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
    private HashMap<String, Long> topicIds;
    
    @EJB
    ProjectStorageService projectStore;
    @EJB
    SupervisorStorageService supervisorStore;
    @EJB
    TopicStorageService topicStore;

    public ProposalBean() {
        supervisorIds = new HashMap<>();
        topicIds = new HashMap<>();
    }
    
    @PostConstruct
    public void loadData() {
        loadSupervisors();
        loadTopics();
    }
    
    public void loadSupervisors() {
        List<Supervisor> supervisors = supervisorStore.getFullSupervisorList();
        for (Supervisor s : supervisors)
            supervisorIds.put(s.getName() + " " + s.getSurname(), s.getId());
    }
    
    public void loadTopics() {
        List<ProjectTopic> topics = topicStore.getFullTopicList();
        for (ProjectTopic t : topics)
            topicIds.put(t.getTitle(), t.getId());
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
        status = "proposed";
        projectStore.insertProject(title, description, skills, status, supervisorIds.get(supervisor), topicIds.get(topic));
        return "proposal-confirmation";
    }
    
    public String submitSupervisorProposal() {
        /* todo: implement logic in an ejb:
         * - grab currently logged in supervisor from context
         * - persist
         */
        status = "available";
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
    
    public List<String> getSupervisors() {
        return new ArrayList<>(supervisorIds.keySet());
    }
    
    public List<String> getTopics() {
        return new ArrayList<>(topicIds.keySet());
    }
    //</editor-fold>
}
