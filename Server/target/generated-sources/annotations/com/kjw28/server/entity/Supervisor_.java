package com.kjw28.server.entity;

import com.kjw28.server.entity.Project;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-09T12:15:51")
@StaticMetamodel(Supervisor.class)
public class Supervisor_ { 

    public static volatile SingularAttribute<Supervisor, String> password;
    public static volatile ListAttribute<Supervisor, Project> projects;
    public static volatile SingularAttribute<Supervisor, String> phone;
    public static volatile SingularAttribute<Supervisor, String> surname;
    public static volatile SingularAttribute<Supervisor, String> name;
    public static volatile SingularAttribute<Supervisor, Long> id;
    public static volatile SingularAttribute<Supervisor, String> department;
    public static volatile SingularAttribute<Supervisor, String> email;

}