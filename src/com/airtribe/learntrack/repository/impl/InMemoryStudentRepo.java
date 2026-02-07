package com.airtribe.learntrack.repository.impl;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStudentRepo implements StudentRepository {

    private final Map<Integer,Student> students = new HashMap<>();
    public void addStudent(Student student) {
//        validateNotNull(student);
        students.put(student.getId(), student);
    }

    public Student findById(int id) {
        return students.get(id);
    }
    public boolean existsById(int id) {
        return students.containsKey(id);
    }
    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }
    public void deleteStudent(int id) {
        students.remove(id);
    }

//    private void validateNotNull(Student student) {
//        if (student == null) {
//            throw new IllegalArgumentException("Student cannot be null");
//        }
//    }
}
