package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }



    public void enrollStudent(int enrollmentId, int studentId, int courseId) {

        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student does not exist");
        }

        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course does not exist");
        }

        if (isStudentEnrolledInCourse(studentId, courseId)) {
            throw new RuntimeException("Student already enrolled in this course");
        }

        Enrollment enrollment = new Enrollment(
                enrollmentId,
                studentId,
                courseId,
                new Date()
        );

        enrollmentRepository.addEnrollment(enrollment);
    }



    public Enrollment getEnrollmentById(int enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findEnrollmentById(enrollmentId);

        if (enrollment == null) {
            throw new RuntimeException("Enrollment not found");
        }

        return enrollment;
    }

    public List<Enrollment> viewAllEnrollments() {
        return new ArrayList<>(enrollmentRepository.findAllEnrollments());
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment enrollment : enrollmentRepository.findAllEnrollments()) {
            if (enrollment.getStudentId() == studentId) {
                result.add(enrollment);
            }
        }
        return result;
    }

    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment enrollment : enrollmentRepository.findAllEnrollments()) {
            if (enrollment.getCourseId() == courseId) {
                result.add(enrollment);
            }
        }
        return result;
    }



    public void cancelEnrollment(int enrollmentId) {
        Enrollment enrollment = getEnrollmentById(enrollmentId);

        if (enrollment.getEnrollmentStatus() == EnrollmentStatus.CANCELLED) {
            throw new RuntimeException("Enrollment already cancelled");
        }

        enrollment.setEnrollmentStatus(EnrollmentStatus.CANCELLED);
    }

    public void completeEnrollment(int enrollmentId) {
        Enrollment enrollment = getEnrollmentById(enrollmentId);

        if (enrollment.getEnrollmentStatus() != EnrollmentStatus.ACTIVE) {
            throw new RuntimeException("Only active enrollments can be completed");
        }

        enrollment.setEnrollmentStatus(EnrollmentStatus.COMPLETED);
    }



    public boolean isStudentEnrolledInCourse(int studentId, int courseId) {
        for (Enrollment enrollment : enrollmentRepository.findAllEnrollments()) {
            if (enrollment.getStudentId() == studentId
                    && enrollment.getCourseId() == courseId
                    && enrollment.getEnrollmentStatus() == EnrollmentStatus.ACTIVE) {
                return true;
            }
        }
        return false;
    }
}
