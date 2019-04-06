package com.kjw28.server.entity;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class TestDataInjector {
    @PersistenceContext EntityManager em;
    
    @PostConstruct
    public void store() {
        Supervisor supervisor = new Supervisor("Paul", "Newbury", "Informatics", "paul.newbury@sussex.ac.uk", "055501234", "password");
        Student student = new Student("Kristian", "Welsh", "Computer Science", "kristian.welsh@sussex.ac.uk", "password");
        Project project = new Project("title", "description", testSkillsList(), "Available", supervisor);
        em.persist(supervisor);
        em.persist(student);
        em.persist(project);
    }
    
    private List<String> testSkillsList() {
        List<String> skills = new ArrayList<>();
        skills.add("skill-1");
        skills.add("skill-2");
        return skills;
    }
}
