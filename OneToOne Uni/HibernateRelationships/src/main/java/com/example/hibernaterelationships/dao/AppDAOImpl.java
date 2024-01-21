package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Instructor;
import com.example.hibernaterelationships.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        entityManager.remove(instructorDetail);
    }
}
