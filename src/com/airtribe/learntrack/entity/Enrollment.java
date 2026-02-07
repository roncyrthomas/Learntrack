package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.util.Date;

public class Enrollment {
    private final int id;
    private final int studentId;
    private final int courseId;
    private Date enrollmentDate;
    private EnrollmentStatus enrollmentStatus ;


    public Enrollment (int id, int studentId, int courseId, Date enrollmentDate){
    this.id = id;
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = enrollmentDate;
    this.enrollmentStatus = EnrollmentStatus.ACTIVE;
    }

    public int getId(){return this.id;}
    public int getStudentId(){return this.studentId;}
    public int getCourseId(){return this.courseId;}
    public Date getEnrollmentDate(){return this.enrollmentDate;}
    public EnrollmentStatus getEnrollmentStatus(){return this.enrollmentStatus;}


    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}
