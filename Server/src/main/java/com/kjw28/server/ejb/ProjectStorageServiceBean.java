package com.kjw28.server.ejb;

import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.ProjectTopic;
import com.kjw28.server.entity.Supervisor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProjectStorageServiceBean implements ProjectStorageService {
    @PersistenceContext EntityManager em;
    
    @EJB
    SupervisorStorageService supervisorStorage;
    @EJB
    TopicStorageService topicStorage;
    
    @Override
    public synchronized List<Project> getFullProjectList() {
        return em.createNamedQuery("findAllProjects").getResultList();
    }
    
    @Override
    public synchronized List<Project> getAvailableProjectList() {
        return em.createNamedQuery("findAvailableProjects").getResultList();
    }
    
    @Override
    public synchronized void insertProject(String title, String description, List<String> skills, String status, Long supervisorId, Long topicId) {
        Supervisor supervisor = supervisorStorage.getSupervisor(supervisorId);
        ProjectTopic topic = topicStorage.getTopic(topicId);
        Project project = new Project(title, description, skills, status, supervisor, topic);
        supervisor.addProject(project);
        em.persist(project);
        em.persist(topic);
        em.persist(supervisor);
    }
    
    @Override
    public synchronized Project getProject(Long id) {
        try {
            Query query = em.createNamedQuery("findProjectById");
            query.setParameter("id", id);
            return (Project)query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
