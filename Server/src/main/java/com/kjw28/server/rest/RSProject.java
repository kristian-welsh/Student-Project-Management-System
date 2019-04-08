package com.kjw28.server.rest;

import com.kjw28.server.ejb.ProjectStorageService;
import com.kjw28.server.ejb.SupervisorStorageService;
import com.kjw28.server.entity.Project;
import com.kjw28.server.entity.Student;
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
@Path("/project")
public class RSProject {
    @EJB
    ProjectStorageService projectStore;
    @EJB
    SupervisorStorageService supervisorStore;
    
    @GET
    @Path("/{proj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("proj") String supervisorIdString) {
        Long supervisorId = Long.parseLong(supervisorIdString);
        Supervisor supervisor = supervisorStore.getSupervisor(supervisorId);
        if(supervisor != null) {
            List<Project> projects = supervisor.getProjects();
            if(projects.size() > 0) {
                return Response.ok(buildMockList(projects)).build();
            } else {
                return Response.noContent().build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjects() {
        List<Project> projects = buildMockList(projectStore.getFullProjectList());
        if(projects.size() > 0)
            return Response.ok(projects).build();
        else
            return Response.noContent().build();
    }
    
    private List<Project> buildMockList(List<Project> originals) {
        List<Project> mocks = new ArrayList<>();
        for(Project p : originals)
            mocks.add(p.copyMock());
        return mocks;
    }
}
