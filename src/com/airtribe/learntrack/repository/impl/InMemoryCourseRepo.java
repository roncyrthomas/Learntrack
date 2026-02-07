package com.airtribe.learntrack.repository.impl;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCourseRepo implements CourseRepository {

    private final Map<Integer,Course> courses = new HashMap<>();

    public void addCourse(Course course) {
//        validateNotNull(course);
        courses.put(course.getCourseId(), course);
    }
    public Course getCourse(int courseId) {
        return courses.get(courseId);

    }
    public List<Course> getCourses() {
        return new ArrayList<Course>(courses.values());
    }
    public Course findById(int courseId) {
        return courses.get(courseId);
    }
    public boolean existsById(int courseId) {
        return courses.containsKey(courseId);
    }
    public void removeCourse(int courseId) {
        courses.remove(courseId);
    }
//    private void validateNotNull (Course course) {
//        if (course==null)
//        {
//            throw new IllegalArgumentException("Course cannot be null");
//        }
//    }
}
