package com.kjw28.server.ejb;

import com.kjw28.server.entity.Student;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StudentStorageServiceBean implements StudentStorageService {
    @PersistenceContext EntityManager em;
    
    @EJB
    SupervisorStorageService supervisorStorage;
    
    @Override
    public synchronized List<Student> getFullStudentList() {
        return em.createNamedQuery("findAllStudents").getResultList();
    }

    @Override
    public Student getStudent(Long id) {
        try {
            Query query = em.createNamedQuery("findStudentById");
            query.setParameter("id", id);
            return (Student)query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
