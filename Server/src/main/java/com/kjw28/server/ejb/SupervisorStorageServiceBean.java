package com.kjw28.server.ejb;

import com.kjw28.server.entity.Supervisor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SupervisorStorageServiceBean implements SupervisorStorageService {
    @PersistenceContext EntityManager em;
    
    @Override
    public synchronized List<Supervisor> getFullSupervisorList() {
        return em.createNamedQuery("findAllSupervisors").getResultList();
    }
    
    @Override
    public synchronized Supervisor getSupervisor(Long id) {
        try {
            Query query = em.createNamedQuery("findSupervisorById");
            query.setParameter("id", id);
            return (Supervisor)query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
