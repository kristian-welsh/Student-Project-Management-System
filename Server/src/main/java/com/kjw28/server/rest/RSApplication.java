package com.kjw28.server.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RSApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(RSProject.class);
        classes.add(RSSupervisor.class);
        classes.add(RSStudent.class);
        return classes;
    }
}
