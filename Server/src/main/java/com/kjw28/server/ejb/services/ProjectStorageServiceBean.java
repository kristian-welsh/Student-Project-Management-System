package com.kjw28.server.ejb.services;

import com.kjw28.server.entity.Project;
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
    public synchronized void insertProject(Project project) {
        em.persist(project);
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

    @Override
    public List<Project> getProposedProjectsForSupervisor(Long id) {
        Query query = em.createNamedQuery("findProposedFromSupervisor");
        query.setParameter("supervisorId", id);
        return query.getResultList();
    }
}
