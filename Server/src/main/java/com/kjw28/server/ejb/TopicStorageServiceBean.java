package com.kjw28.server.ejb;

import com.kjw28.server.entity.ProjectTopic;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TopicStorageServiceBean implements TopicStorageService {
    @PersistenceContext EntityManager em;
    
    @Override
    public synchronized List<ProjectTopic> getFullTopicList() {
        return em.createNamedQuery("findAllTopics").getResultList();
    }
    
    @Override
    public synchronized void insertTopic(String title) {
        ProjectTopic topic = new ProjectTopic(title);
        em.persist(topic);
    }
    
    @Override
    public synchronized ProjectTopic getTopic(Long id) {
        try {
            Query query = em.createNamedQuery("findTopicById");
            query.setParameter("id", id);
            return (ProjectTopic)query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
