package com.kjw28.server.entity;

import com.kjw28.server.entity.ProjectTopic;
import com.kjw28.server.entity.Student;
import com.kjw28.server.entity.Supervisor;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-12T14:28:18")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, List> skills;
    public static volatile SingularAttribute<Project, Student> student;
    public static volatile SingularAttribute<Project, String> description;
    public static volatile SingularAttribute<Project, ProjectTopic> topic;
    public static volatile SingularAttribute<Project, Long> id;
    public static volatile SingularAttribute<Project, String> title;
    public static volatile SingularAttribute<Project, Supervisor> supervisor;
    public static volatile SingularAttribute<Project, String> status;

}