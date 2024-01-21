package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Student;

import java.util.List;

public interface AppDAO {

    Course findCourseById(int id);


    Course findCourseAndStudentsById(int id);

    Student findStudentAndCoursesById(int id);

    void updateStudentWithNewCourses(Student tmpStudent);

    Student findStudentById(int id);

    void deleteCourseById(int id);

    void deleteStudentById(int id);
}
