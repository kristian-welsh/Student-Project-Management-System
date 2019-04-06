package com.kjw28.server.ejb;

import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.Supervisor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectStorageServiceBean implements ProjectStorageService {
    @PersistenceContext EntityManager em;
    
    @EJB
    SupervisorStorageService supervisorStorage;
    
    @Override
    public synchronized List<Project> getFullProjectList() {
        return em.createNamedQuery("findAllProjects").getResultList();
    }
    
    @Override
    public synchronized void insertProject(String title, String description, List<String> skills, String status, Long supervisorId) {
        Supervisor supervisor = supervisorStorage.getSupervisor(supervisorId);
        Project project = new Project(title, description, skills, status, supervisor);
        supervisor.addProject(project);
        em.persist(project);
        em.persist(supervisor);
    }
}
