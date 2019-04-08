package com.kjw28.server.ejb;

import java.util.List;
import com.kjw28.server.entity.Student;

public interface StudentStorageService {
    List<Student> getFullStudentList();
    Student getStudent(Long id);
}
