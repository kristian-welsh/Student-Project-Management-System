package com.kjw28.server.jsf;

import com.kjw28.server.ejb.ProposalLogic;
import com.kjw28.server.entity.dto.ProjectDTO;
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
    
    private HashMap<String, Long> supervisorIds;
    private HashMap<String, Long> topicIds;
    
    @EJB
    ProposalLogic proposalLogic;

    public ProposalBean() {
        supervisorIds = new HashMap<>();
        topicIds = new HashMap<>();
    }
    
    @PostConstruct
    public void loadData() {
        supervisorIds = proposalLogic.getSupervisorMap();
        topicIds = proposalLogic.getTopicMap();
    }
    
    public String submitStudentProposal() {
        ProjectDTO project = new ProjectDTO(title, description, skills, "proposed",
                supervisorIds.get(supervisor), topicIds.get(topic));
        proposalLogic.submitProposal(project);
        return "proposal-confirmation";
    }
    
    public String submitSupervisorProposal() {
        /* todo: implement logic in an ejb:
         * - grab currently logged in supervisor from context
         * - persist
         */
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
    
    public List<String> getSupervisors() {
        return new ArrayList<>(supervisorIds.keySet());
    }
    
    public List<String> getTopics() {
        return new ArrayList<>(topicIds.keySet());
    }
    //</editor-fold>
}
