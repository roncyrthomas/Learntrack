package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

public class Trainer extends Person {
    private String courseId;

    public Trainer(int id, String firstName, String lastName, String email,String courseId) {
        super(id,firstName,lastName,email);
        this.courseId = courseId;
    }

    public void setCourseId(String CourseId) {
        this.courseId = CourseId;
    }
    public String getCourseId() {
        return courseId;
    }
}
