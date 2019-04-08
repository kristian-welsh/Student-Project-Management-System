package com.kjw28.server.rest;

import com.kjw28.server.ejb.ProjectStorageService;
import com.kjw28.server.ejb.StudentStorageService;
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
@Path("/supervisor")
public class RSSupervisor {
    @EJB
    SupervisorStorageService supervisorStore;
    @EJB
    StudentStorageService studentStore;
    @EJB
    ProjectStorageService projectStore;
    
    @GET
    @Path("/{sup}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupervisor(@PathParam("sup") String studentIdString) {
        Long studentId = Long.parseLong(studentIdString);
        Student student = studentStore.getStudent(studentId);
        if(student != null) {
            Project project = student.getProject();
            if(project != null)
                return Response.ok(project.getSupervisor().copyMock()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supervisor> getAllSupervisors() {
        return buildMockList(supervisorStore.getFullSupervisorList());
    }
    
    private List<Supervisor> buildMockList(List<Supervisor> originals) {
        List<Supervisor> mocks = new ArrayList<>();
        for(Supervisor s : originals)
            mocks.add(s.copyMock());
        return mocks;
    }
}
