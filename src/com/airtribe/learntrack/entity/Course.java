package com.airtribe.learntrack.entity;

public class Course {
    private final int courseId;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    private  int durationInWeeks;
    private boolean active;

    public Course(int courseId, String courseName, String courseDescription, int durationInWeeks, boolean active){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getCourseId(){return courseId;}
    public String getCourseName(){return courseName;}
    public String getCourseDescription(){return courseDescription;}
    public int getDurationInWeeks(){return durationInWeeks;}
    public boolean isActive(){return active;}

    public void setCourseName(String courseName){this.courseName = courseName;}
    public void setCourseDescription(String courseDescription){this.courseDescription = courseDescription;}
    public void setDurationInWeeks(int durationInWeeks) {
        if (durationInWeeks <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.durationInWeeks = durationInWeeks;
    }

    public void setActive(boolean active){this.active = active;}

}
