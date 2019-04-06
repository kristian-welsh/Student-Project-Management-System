package com.kjw28.server.rest;

import com.kjw28.server.entity.Supervisor;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/supervisor")
public class RSSupervisor {
    HashMap<Integer, Supervisor> supervisors;
    
    public RSSupervisor() {
        Supervisor supervisor = new Supervisor("Paul", "Newbury", "Informatics", "paul.newbury@sussex.ac.uk", "055501234", "password");
        supervisors = new HashMap<>();
        supervisors.put(1, supervisor);
    }
    
    @GET
    @Path("/{sup}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupervisor(@PathParam("sup") String supervisorId) {
        // todo: db backend
        Supervisor project = supervisors.get(Integer.parseInt(supervisorId));
        if (project == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(project).build();
        }
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Supervisor> getAllSupervisors() {
        // todo: db backend
        return new ArrayList<>(supervisors.values());
    }
}
