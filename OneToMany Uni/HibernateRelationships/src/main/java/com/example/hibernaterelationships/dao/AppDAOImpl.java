package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }


    @Override
    public Course findCourseAndReviews(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.reviews where c.id = :data", Course.class);

        query.setParameter("data", id);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public void findReviewsByCourseId(int id) { // Finding reviews of a specific Course.
        Course tempCourse = entityManager.find(Course.class, id);

        List<Review> reviews = tempCourse.getReviews();
        System.out.println("Reviews of Course ID " + id + ": " + reviews);

    }

    @Override
    public void deleteCourseAndReviews(int id) { // This will delete the course and its reviews due to Cascade type ALL
        Course tempCourse = entityManager.find(Course.class, id);

        System.out.println("Deleting Course ID: " + id);
        entityManager.remove(tempCourse);
    }


}
