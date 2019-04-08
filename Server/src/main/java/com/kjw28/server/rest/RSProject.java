package com.kjw28.server.rest;

import com.kjw28.server.ejb.ProjectStorageService;
import com.kjw28.server.entity.Project;
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
@Path("/project")
public class RSProject {
    @EJB
    ProjectStorageService projectStore;
    
    @GET
    @Path("/{proj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("proj") String supervisorId) {
        Long id = Long .parseLong(supervisorId);
        Project project = projectStore.getProject(id);
        if (project == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(project.copyMock()).build();
        }
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getAllProjects() {
        List<Project> originals = projectStore.getFullProjectList();
        List<Project> mocks = new ArrayList<>();
        for(Project p : originals)
            mocks.add(p.copyMock());
        return mocks;
    }
}
