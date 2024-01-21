package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Course;

import java.util.List;

public interface AppDAO {

    Course findCourseById(int id);

    Course findCourseAndReviews(int id);

    void findReviewsByCourseId(int id);

    void deleteCourseAndReviews(int id);
}
