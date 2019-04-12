package com.kjw28.server.jsf;

import com.kjw28.server.ejb.NewTopicLogic;
import com.kjw28.server.entity.dto.ProjectTopicDTO;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NewTopicBean {
    private String title = "";
    
    @EJB
    NewTopicLogic logic;

    public String getTitle() {
        return title;
    }
    
    public String submitTopic() {
        logic.submitNewTopic(new ProjectTopicDTO(title));
        return "successful";
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public void setTitle(String title) {
        this.title = title;
    }
    //</editor-fold>
}
