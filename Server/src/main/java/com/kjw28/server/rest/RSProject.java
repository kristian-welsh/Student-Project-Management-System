package com.kjw28.server.rest;

import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.Supervisor;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/project")
public class RSProject {
    HashMap<Integer, Project> projects;
    
    @PostConstruct
    public void populateTestData() {
        Supervisor supervisor = new Supervisor("Paul", "Newbury", "Informatics", "paul.newbury@sussex.ac.uk", "055501234", "password");
        ArrayList<String> skills = new ArrayList<>();
        skills.add("skill-1");
        skills.add("skill-2");
        Project project = new Project("title", "description", skills, "Proposed", supervisor);
        projects = new HashMap<>();
        projects.put(1, project);
    }
    
    @GET
    @Path("/{sup}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("sup") String supervisorId) {
        // todo: db backend
        Project project = projects.get(Integer.parseInt(supervisorId));
        if (project == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(project).build();
        }
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Project> getAllProjects() {
        // todo: db backend
        return new ArrayList<>(projects.values());
    }
}
