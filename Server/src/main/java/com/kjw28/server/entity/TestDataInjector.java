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
        ProjectTopic topic = new ProjectTopic("Natural Language Engineering");
        Project project = new Project("title", "description", testSkillsList(), "available", supervisor, topic);
        Student student = new Student("Kristian", "Welsh", "Computer Science", "kristian.welsh@sussex.ac.uk", "password", project);
        project.setStudent(student);
        em.persist(supervisor);
        em.persist(student);
        em.persist(topic);
        em.persist(project);
    }
    
    private List<String> testSkillsList() {
        List<String> skills = new ArrayList<>();
        skills.add("skill-1");
        skills.add("skill-2");
        return skills;
    }
}
