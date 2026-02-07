package com.airtribe.learntrack.repository.impl;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEnrollmentRepo implements EnrollmentRepository {

    private  final Map<Integer, Enrollment> enrollments = new HashMap<>();
    public void addEnrollment(Enrollment enrollment)
    {
//        validateNotNull(enrollment);
        enrollments.put(enrollment.getId(), enrollment);
    }
    public void removeEnrollment(Enrollment enrollment)
    {
        enrollments.remove(enrollment.getId());
    }
    public Enrollment findEnrollmentById(int id)
    {
        return enrollments.get(id);
    }
    public List<Enrollment> findAllEnrollments()
    {
        return new ArrayList<>(enrollments.values());
    }
    public boolean existsById(int id)
    {
        return enrollments.containsKey(id);
    }

//    private void validateNotNull(Enrollment enrollment)
//    {
//        if (enrollment == null)
//        {
//            throw new IllegalArgumentException("Enrollment must not be null");
//        }
//    }


}
