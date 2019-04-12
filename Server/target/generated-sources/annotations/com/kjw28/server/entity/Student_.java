package com.kjw28.server.entity;

import com.kjw28.server.entity.Project;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-12T14:28:18")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> password;
    public static volatile SingularAttribute<Student, String> surname;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, String> course;
    public static volatile SingularAttribute<Student, Project> project;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, String> email;

}