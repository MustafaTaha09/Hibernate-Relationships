package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Instructor;
import com.example.hibernaterelationships.entity.InstructorDetail;
import org.springframework.stereotype.Repository;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
