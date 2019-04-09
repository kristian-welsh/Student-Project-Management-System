package com.kjw28.server.jsf;

import com.kjw28.server.ejb.TopicStorageService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NewTopicBean {
    private String title = "";
    
    @EJB
    TopicStorageService topicStore;

    public String getTitle() {
        return title;
    }
    
    public String submitTopic() {
        // todo: check if a topic has this title already
        // in seperate function called by a validator in page
        topicStore.insertTopic(title);
        return "successful";
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public void setTitle(String title) {
        this.title = title;
    }
    //</editor-fold>
}
