package com.kjw28.server.ejb.services;

import com.kjw28.server.entity.ProjectTopic;
import java.util.List;

public interface TopicStorageService {
    List<ProjectTopic> getFullTopicList();
    void insertTopic(ProjectTopic topic);
    ProjectTopic getTopic(Long id);
}
