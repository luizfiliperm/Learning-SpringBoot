package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.InstructorRepository;
import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository instructorRepository){
		return runner ->{
			createInstructor(instructorRepository);
		};
	}

	private void createInstructor(InstructorRepository instructorRepository){
		Instructor instructor = new Instructor("Luiz", "Filipe", "luiz@gmail.com", null);

		InstructorDetail instructorDetail = new InstructorDetail("luizfilipe", "Guittar");

		instructor.setInstructorDetail(instructorDetail);

		instructorRepository.save(instructor);
		System.out.println("Instructor save: " + instructor);
	}
}
