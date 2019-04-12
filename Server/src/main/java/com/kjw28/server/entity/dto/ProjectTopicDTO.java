package com.kjw28.server.entity.dto;

import java.util.List;

public class ProjectTopicDTO {
    public Long id;
    public String title;
    public List<ProjectDTO> projects;

    public ProjectTopicDTO() {
        // intentionally blank
    }

    public ProjectTopicDTO(String title) {
        this.title = title;
    }
}
