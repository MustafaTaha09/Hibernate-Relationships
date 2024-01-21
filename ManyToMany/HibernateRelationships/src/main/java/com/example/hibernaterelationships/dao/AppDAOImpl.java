package com.example.hibernaterelationships.dao;

import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Course findCourseAndStudentsById(int id) { // This retrieves a Course and all of its Students

        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.students where c.id = :data", Course.class);
        query.setParameter("data", id);
        Course tmpCourse = query.getSingleResult();

        return tmpCourse;
    }

    @Override
    public Student findStudentAndCoursesById(int id) { // This retrieves a Student and all of its Courses
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s join fetch s.courses where s.id = :data", Student.class);
        query.setParameter("data", id);
        Student tempStudent = query.getSingleResult();

        return tempStudent;
    }

    @Override
    public void updateStudentWithNewCourses(Student tmpStudent) {
        entityManager.merge(tmpStudent);
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteCourseById(int id) { // Only deletes Course without deleting Students due to the Cascade type of REMOVE
        Course tmpCourse = entityManager.find(Course.class, id);

        entityManager.remove(tmpCourse);
    }

    @Override
    public void deleteStudentById(int id) {
        Student s = entityManager.find(Student.class, id);

        entityManager.remove(s);
    }


}
