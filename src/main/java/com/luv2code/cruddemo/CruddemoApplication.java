package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entities.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			readStudent(studentDAO);
		};
	}


	private Student createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Luiz", "Filipe", "luizfilipe@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		// display the student id
		System.out.println("Student saved. Generated id: " + newStudent.getId());

		return newStudent;

	}

	private void readStudent(StudentDAO studentDAO){
		
		// create a student object

		Student newStudent = createStudent(studentDAO);

		// retrieve the student from the database based on id: primary key

		Student myStudent = studentDAO.findById(newStudent.getId());

		// display the student
		
		System.out.println("Found the student: " + myStudent);

	}
}
