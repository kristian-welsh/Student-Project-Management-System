package com.kjw28.server.ejb;

import com.kjw28.server.ejb.services.TopicStorageService;
import com.kjw28.server.entity.ProjectTopic;
import com.kjw28.server.entity.dto.ProjectTopicDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NewTopicLogicBean implements NewTopicLogic {
    
    @EJB
    TopicStorageService topicStore;

    @Override
    public void submitNewTopic(ProjectTopicDTO topicDTO) {
        ProjectTopic topicEntity = new ProjectTopic(topicDTO);
        topicStore.insertTopic(topicEntity);
    }
    
}
