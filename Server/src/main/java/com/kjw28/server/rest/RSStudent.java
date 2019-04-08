package com.kjw28.server.rest;

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
@Path("/student")
public class RSStudent {
    @EJB
    SupervisorStorageService supervisorStore;
    @EJB
    StudentStorageService studentStore;
    
    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("studentId") String supervisorIdString) {
        Long supervisorId = Long.parseLong(supervisorIdString);
        Supervisor supervisor = supervisorStore.getSupervisor(supervisorId);
        if(supervisor != null) {
            List<Project> projects = supervisor.getProjects();
            List<Student> mocks = buildMockList(studentsFromProjects(projects));
            return Response.ok(mocks).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        return buildMockList(studentStore.getFullStudentList());
    }
    
    private List<Student> buildMockList(List<Student> originals) {
        List<Student> mocks = new ArrayList<>();
        for(Student p : originals)
            mocks.add(p.copyMock());
        return mocks;
    }
    
    private List<Student> studentsFromProjects(List<Project> projects) {
        List<Student> students = new ArrayList<>();
        for(Project p : projects)
            students.add(p.getStudent());
        return students;
    }
}
