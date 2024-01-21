package com.example.hibernaterelationships;

import com.example.hibernaterelationships.dao.AppDAO;
import com.example.hibernaterelationships.entity.Course;
import com.example.hibernaterelationships.entity.Instructor;
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

//          createInstructor(appDAO);
//			findInstructor(appDAO);
//          createInstructorWithCourses(appDAO);
//          findInstructorWithCourses(appDAO);
//          deleteInstructorWithCascadeType(appDAO);
            deleteCourseWithCascadeType(appDAO);
        };
    }

    private void deleteCourseWithCascadeType(AppDAO appDAO) {
        int id = 7;
        appDAO.deleteCourseById(id);
    }

    private void deleteInstructorWithCascadeType(AppDAO appDAO) {
        int id = 8;
        appDAO.deleteInstructorById(id);
    }


    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 8;
        // print Instructor attributes only (lazy fetch).
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Instructor of id: " + id + " is found!");
        System.out.println(instructor);

        // print Instructor and courses (lazy fetch).
        List<Course> courses = new ArrayList<>();
        courses = appDAO.findCoursesByInstructorId(5);
        instructor.setCourses(courses);
        System.out.println("Courses of Instructor ID: " + id + " are: " + instructor.toStringWithCourses());

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Mariam", "Taha", "Mariam@gmail.com");

        List<Course> li = new ArrayList<>();
        li.add(new Course("NONE"));
        li.add(new Course("ADVANCED NONE"));

        // adding every course in the instructor's courses list
        tempInstructor.setCourses(li);
        System.out.println(tempInstructor.getCourses());

        appDAO.saveInstructorWithCourse(tempInstructor);

    }

    private void findInstructor(AppDAO appDAO) {
        int ins_id = 1;
        System.out.println("Finding instructor id: " + ins_id);

        Instructor instructor = appDAO.findInstructorById(ins_id);

        System.out.println("instructor: " + instructor);

    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Mustafa", "Taha", "mustafa@gmail.com");

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Saved!");
    }
}
