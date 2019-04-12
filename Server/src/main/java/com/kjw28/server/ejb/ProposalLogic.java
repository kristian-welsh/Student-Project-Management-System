package com.kjw28.server.ejb;

import com.kjw28.server.entity.dto.ProjectDTO;
import java.util.HashMap;

public interface ProposalLogic {
    void submitProposal(ProjectDTO project);
    HashMap<String, Long> getSupervisorMap();
    HashMap<String, Long> getTopicMap();
}
