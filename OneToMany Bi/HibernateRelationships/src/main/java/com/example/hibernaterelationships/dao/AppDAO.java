package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Instructor;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void saveInstructorWithCourse(Instructor instructor);

    List<Course> findCoursesByInstructorId(int id);

    void deleteInstructorById(int id);

    Course findCourseById(int id);

    void deleteCourseById(int id);
}
