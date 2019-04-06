package com.kjw28.server.ejb;

import com.kjw28.server.entity.Project;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectStorageServiceBean implements ProjectStorageService {
    @PersistenceContext EntityManager em;
    
    @Override
    public synchronized List<Project> getFullProjectList() {
        return em.createNamedQuery("findAllProjects").getResultList();
    }
    
    @Override
    public synchronized void insertProject(String title, String description, List<String> skills, String status) {
        Project project = new Project(title, description, skills, status);
        em.persist(project);
    }
}
