package com.kjw28.server.ejb;

import java.util.List;
import com.kjw28.server.entity.Supervisor;

public interface SupervisorStorageService {
    List<Supervisor> getFullSupervisorList();
    Supervisor getSupervisor(Long id);
}
