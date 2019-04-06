package com.kjw28.server.rest;

import com.kjw28.server.entity.Student;
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
@Path("/student")
public class RSStudent {
    HashMap<Integer, Student> students;
    
    public RSStudent() {
        Student student = new Student("Kristian", "Welsh", "Computer Science", "kristian.welsh@sussex.ac.uk", "password");
        students = new HashMap<>();
        students.put(1, student);
    }
    
    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("studentId") String studentId) {
        // todo: db backend
        Student project = students.get(Integer.parseInt(studentId));
        if (project == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(project).build();
        }
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Student> getAllStudents() {
        // todo: db backend
        return new ArrayList<>(students.values());
    }
}
