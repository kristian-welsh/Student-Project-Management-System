package com.kjw28.server.ejb;

import java.util.ArrayList;
import com.kjw28.server.entity.Project;

public interface ProjectStorageService {
    ArrayList<Project> getFullProjectList();
    // todo: insert project
}
