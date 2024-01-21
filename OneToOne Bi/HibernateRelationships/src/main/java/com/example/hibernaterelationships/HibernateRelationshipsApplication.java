package com.example.hibernaterelationships;

import com.example.hibernaterelationships.dao.AppDAO;
import com.example.hibernaterelationships.entity.Instructor;
import com.example.hibernaterelationships.entity.InstructorDetail;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateRelationshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateRelationshipsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);

//			findInstructor(appDAO);

//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int ins_id=7;
		System.out.println("Deleting instructorDetail&Instructor id: " + ins_id);

		appDAO.deleteInstructorDetailById(ins_id);
		System.out.println("Done!");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int ins_id=1;
		System.out.println("Finding instructorDetail id: " + ins_id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(ins_id);

		System.out.println("instructorDetail: " + instructorDetail);

		System.out.println("Instructor: " + instructorDetail.getInstructor());
	}
	private void findInstructor(AppDAO appDAO) {
		int ins_id=1;
		System.out.println("Finding instructor id: " + ins_id);

		Instructor instructor = appDAO.findInstructorById(ins_id);

		System.out.println("instructor: " + instructor);

	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor = new Instructor("Mustafa", "Taha", "mustafa@gmail.com");
//
//		InstructorDetail instructorDetail = new InstructorDetail("watever@utube.com", "Coding!");
//
//		tempInstructor.setInstructorDetail(instructorDetail);

		Instructor tempInstructor = new Instructor("ssss", "jassssss", "masriasmsssss@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("mar@utube.com", "reading!");

		tempInstructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Saved!");
	}
}
