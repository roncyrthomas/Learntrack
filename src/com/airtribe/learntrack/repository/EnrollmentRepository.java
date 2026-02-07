package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.List;

public interface EnrollmentRepository {

    void addEnrollment(Enrollment enrollment);

    Enrollment findEnrollmentById(int id);

    List<Enrollment> findAllEnrollments();

    void removeEnrollment(Enrollment enrollment);

    boolean existsById(int id);
}
