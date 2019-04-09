package com.kjw28.server.ejb;

import java.util.List;
import com.kjw28.server.entity.ProjectTopic;

public interface TopicStorageService {
    List<ProjectTopic> getFullTopicList();
    void insertTopic(String title);
    ProjectTopic getTopic(Long id);
}
