package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override

    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void saveInstructorWithCourse(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        // create query  to retrieve courses by instructorId
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        List<Course> courses = query.getResultList();

        return courses;

    }

    @Override
    public void deleteInstructorById( int id) {
        Instructor ins = findInstructorById(id);
        System.out.println("found instructor of id: " + id + " to be removed!");

        // This is situational helper method used to break association between courses and their instructors.
        // May not be needed if we have cascade type REMOVE in the instructor entity. otherwise, we will need it!
        List<Course> courses = ins.getCourses();
        for(Course tempCourse : courses)
            tempCourse.setInstructor(null);

        // this should remove the instructor along with its courses bcz of the cascade type.
        entityManager.remove(ins);


    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteCourseById(int id) {
        Course tempCourse = entityManager.find(Course.class, id);
        System.out.println("Course ID: " + id + " being Deleted!");

        // This won't delete the Instructor associated with that course because the cascade type REMOVE is not defined in the Course class.
        entityManager.remove(tempCourse);
    }


}
