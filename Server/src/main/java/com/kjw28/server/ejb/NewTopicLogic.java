package com.kjw28.server.ejb;

import com.kjw28.server.entity.dto.ProjectTopicDTO;

public interface NewTopicLogic {
    void submitNewTopic(ProjectTopicDTO topicDTO);
}
