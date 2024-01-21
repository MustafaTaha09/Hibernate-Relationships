package com.example.hibernaterelationships;

import com.example.hibernaterelationships.dao.AppDAO;
import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Student;
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
//            viewCoursesAndStudents(appDAO);
//            viewStudentAndCourses(appDAO);
//            updateStudentWithNewCourses(appDAO);
//            deleteCourse(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int id = 3;
        System.out.println("Deleting Student of ID: " + id);
        appDAO.deleteStudentById(id);
    }

    private void deleteCourse(AppDAO appDAO) { // Only deletes Course without deleting Students due to the Cascade type of REMOVE
        int id = 4;
        System.out.println("Deleting Course of ID: " + id);
        appDAO.deleteCourseById(id);

    }

    private void updateStudentWithNewCourses(AppDAO appDAO) {
        int id = 2;

        Student tempStudent = appDAO.findStudentAndCoursesById(id);
        Course c1 = new Course("DS");
        tempStudent.addCourse(c1);

        appDAO.updateStudentWithNewCourses(tempStudent);
    }

    private void viewStudentAndCourses(AppDAO appDAO) { // This retrieves a Course and all of its Students
        int id = 2;
        Student s = appDAO.findStudentAndCoursesById(id);
        System.out.println("Student of ID: " + id + " is found!");
        System.out.println(s.toStringWithCourses());
    }

    private void viewCoursesAndStudents(AppDAO appDAO) { // This retrieves a Student and all of its Courses
        int id = 1;
        Course c = appDAO.findCourseAndStudentsById(id);

        System.out.println("Course of ID: " + id + " is found!");
        System.out.println(c);
        System.out.println(c.getStudents());
    }


}
