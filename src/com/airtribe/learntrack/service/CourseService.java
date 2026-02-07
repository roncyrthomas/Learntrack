package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public void addCourse(int courseId, String courseCode, String courseName,
                          String courseDescription, int durationInWeeks) {

        if (courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course already exists");
        }

        Course course = new Course(courseId, courseName, courseDescription, durationInWeeks, true);
        courseRepository.addCourse(course);
    }


    public Course searchCourseById(int id) {
        return getExistingCourse(id);
    }

    public List<Course> viewAllCourses() {
        return new ArrayList<>(courseRepository.getCourses());
    }

    public List<Course> viewAllActiveCourses() {
        List<Course> activeCourses = new ArrayList<>();

        for (Course course : courseRepository.getCourses()) {
            if (course.isActive()) {
                activeCourses.add(course);
            }
        }
        return activeCourses;
    }


    public void activateCourse(int id) {
        Course course = getExistingCourse(id);

        if (course.isActive()) {
            throw new RuntimeException("Course is already active");
        }
        course.setActive(true);
    }

    public void deactivateCourse(int id) {
        Course course = getExistingCourse(id);

        if (!course.isActive()) {
            throw new RuntimeException("Course is already inactive");
        }
        course.setActive(false);
    }

    public void updateCourseDetails(int id, String name,
                                    String description, int durationInWeeks) {

        Course course = getExistingCourse(id);

        course.setCourseName(name);
        course.setCourseDescription(description);
        course.setDurationInWeeks(durationInWeeks);
    }

    public void updateCourseDuration(int id, int durationInWeeks) {
        Course course = getExistingCourse(id);
        course.setDurationInWeeks(durationInWeeks);
    }

    public boolean courseExists(int id) {
        return courseRepository.existsById(id);
    }

    private Course getExistingCourse(int id) {
        Course course = courseRepository.getCourse(id);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }
        return course;
    }
}
