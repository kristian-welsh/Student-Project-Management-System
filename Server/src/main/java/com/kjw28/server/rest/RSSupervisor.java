package com.kjw28.server.rest;

import com.kjw28.server.ejb.SupervisorStorageService;
import com.kjw28.server.entity.Supervisor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    SupervisorStorageService supervisorStore;
    
    @GET
    @Path("/{sup}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupervisor(@PathParam("sup") String supervisorId) {
        Long id = Long.parseLong(supervisorId);
        Supervisor supervisor = supervisorStore.getSupervisor(id);
        if (supervisor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(supervisor.copyMock()).build();
        }
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supervisor> getAllSupervisors() {
        List<Supervisor> originals = supervisorStore.getFullSupervisorList();
        List<Supervisor> mocks = new ArrayList<>();
        for(Supervisor s : originals)
            mocks.add(s.copyMock());
        return mocks;
    }
}
