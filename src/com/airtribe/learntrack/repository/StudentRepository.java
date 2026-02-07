package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.List;

public interface StudentRepository {

    void addStudent(Student student);

    Student findById(int id);

    List<Student> getStudents();

    void deleteStudent(int id);

    boolean existsById(int id);
}
