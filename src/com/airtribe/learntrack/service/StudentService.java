package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void createStudent(int id, String firstName, String lastName,
                              String email) {

        if (studentRepository.existsById(id)) {
            throw new RuntimeException("Student already exists");
        }

        Student student = new Student(id, firstName, lastName, email, true);
        studentRepository.addStudent(student);
    }


    public Student searchStudentById(int id) {
        return getExistingStudent(id);
    }

    public List<Student> viewAllStudents() {
        return new ArrayList<>(studentRepository.getStudents());
    }

    public List<Student> viewAllActiveStudents() {
        List<Student> activeStudents = new ArrayList<>();

        for (Student student : studentRepository.getStudents()) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }


    public void activateStudent(int id) {
        Student student = getExistingStudent(id);

        if (student.isActive()) {
            throw new RuntimeException("Student is already active");
        }
        student.setActive(true);
    }

    public void deactivateStudent(int id) {
        Student student = getExistingStudent(id);

        if (!student.isActive()) {
            throw new RuntimeException("Student is already inactive");
        }
        student.setActive(false);
    }


    public boolean studentExists(int id) {
        return studentRepository.existsById(id);
    }

    private Student getExistingStudent(int id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        return student;
    }
}
