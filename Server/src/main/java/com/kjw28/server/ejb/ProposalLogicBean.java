package com.kjw28.server.ejb;

import com.kjw28.server.ejb.services.ProjectStorageService;
import com.kjw28.server.ejb.services.SupervisorStorageService;
import com.kjw28.server.ejb.services.TopicStorageService;
import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.ProjectTopic;
import com.kjw28.server.entity.Supervisor;
import com.kjw28.server.entity.dto.ProjectDTO;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProposalLogicBean implements ProposalLogic {
    @EJB
    ProjectStorageService projectStore;
    @EJB
    SupervisorStorageService supervisorStore;
    @EJB
    TopicStorageService topicStore;
    
    /* todo:
     * - stop submission if student has proposed project that hasn't
     *       been accepted yet (probably re-use current proposed)
     * - get logged in student and set project on them to be the created project
     */
    @Override
    public void submitProposal(ProjectDTO projectDTO) {
        Supervisor supervisor = supervisorStore.getSupervisor(projectDTO.supervisorId);
        ProjectTopic topic = topicStore.getTopic(projectDTO.topicId);
        Project project = new Project(projectDTO, supervisor, topic);
        supervisor.addProject(project);
        topic.addProject(project);
        projectStore.insertProject(project);
    }
    
    @Override
    public HashMap<String, Long> getSupervisorMap() {
        HashMap<String, Long> map = new HashMap<>();
        List<Supervisor> supervisors = supervisorStore.getFullSupervisorList();
        for (Supervisor s : supervisors)
            map.put(s.getName() + " " + s.getSurname(), s.getId());
        return map;
    }
    
    @Override
    public HashMap<String, Long> getTopicMap() {
        HashMap<String, Long> map = new HashMap<>();
        List<ProjectTopic> topics = topicStore.getFullTopicList();
        for (ProjectTopic t : topics)
            map.put(t.getTitle(), t.getId());
        return map;
    }
}
