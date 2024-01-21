package com.example.hibernaterelationships;

import com.example.hibernaterelationships.dao.AppDAO;
import com.example.hibernaterelationships.entity.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateRelationshipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateRelationshipsApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            viewCourse(appDAO);
//            viewCoursesAndReviews(appDAO);
//            viewReviewsByCourseId(appDAO);
            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteCourseAndReviews(id);
    }

    private void viewReviewsByCourseId(AppDAO appDAO) {
        int id = 2;
        appDAO.findReviewsByCourseId(id);
    }

    private void viewCourse(AppDAO appDAO) {
        int id = 1;
        System.out.println(appDAO.findCourseById(id));
    }

    private void viewCoursesAndReviews(AppDAO appDAO) {
        int id = 1;
        Course course = appDAO.findCourseAndReviews(1);
        System.out.println(course.toStringWithReviews());
    }


}
