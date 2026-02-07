package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int studentId = 1000;
    private static int courseId = 2000;
    private static int enrollmentId = 3000;

    private IdGenerator() {}

    public static int nextStudentId() {
        return ++studentId;
    }

    public static int nextCourseId() {
        return ++courseId;
    }

    public static int nextEnrollmentId() {
        return ++enrollmentId;
    }
}
