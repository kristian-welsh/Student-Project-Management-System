package com.kjw28.server.rest;

import com.kjw28.server.ejb.StudentStorageService;
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
    StudentStorageService studentStore;
    
    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("studentId") String studentId) {
        Long id = Long.parseLong(studentId);
        Student student = studentStore.getStudent(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(student.copyMock()).build();
        }
    }
    
    private List<String> testSkillsList() {
        List<String> skills = new ArrayList<>();
        skills.add("skill-1");
        skills.add("skill-2");
        return skills;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        List<Student> originals = studentStore.getFullStudentList();
        List<Student> mocks = new ArrayList<>();
        for(Student s : originals)
            mocks.add(s.copyMock());
        return mocks;
    }
}
