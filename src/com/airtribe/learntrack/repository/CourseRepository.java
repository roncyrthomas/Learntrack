package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.List;

public interface CourseRepository {

    void addCourse(Course course);

    Course getCourse(int courseId);

    List<Course> getCourses();

    void removeCourse(int courseId);

    boolean existsById(int courseId);
}
