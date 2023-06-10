package com.luv2code.cruddemo;

import java.util.List;

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
			createStudent(studentDAO, "Luiz", "Filipe", "luizfilipe@gmailcom");
			createStudent(studentDAO, "Carlos", "Filipe", "carlosfilipe@gmailcom");
			createStudent(studentDAO, "Maria", "Esther", "mariaEsther@gmailcom");

			// readStudent(studentDAO);
			// findAllStudent(studentDAO);
			// findByLastName(studentDAO);
			// updateStudent(studentDAO, 3001);
			// deleteById(studentDAO, 3001);
			// deleteAll(studentDAO);
		};
	}


	private Student createStudent(StudentDAO studentDAO, String firstName, String lastName, String email) {

		// create the student object
		System.out.println("Creating new student object...");
		Student newStudent = new Student(firstName, lastName, email);

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		// display the student id
		System.out.println("Student saved. Generated id: " + newStudent.getId());

		return newStudent;

	}

	private void readStudent(StudentDAO studentDAO){
		
		// create a student object

		Student newStudent = createStudent(studentDAO, "Luiz", "Filipe", "luizfilipe@gmailcom");

		// retrieve the student from the database based on id: primary key

		Student myStudent = studentDAO.findById(newStudent.getId());

		// display the student

		System.out.println("Found the student: " + myStudent);

	}

	private void findAllStudent(StudentDAO studentDAO){

		List<Student> students = studentDAO.findAll();

		students.forEach(System.out::println);
	}

	private void findByLastName(StudentDAO studentDAO){

		// get a list of students for last name: Filipe
		List<Student> students = studentDAO.findByLastName("Filipe");

		// display the students
		students.forEach(System.out::println);
	}

	private void updateStudent(StudentDAO studentDAO, Integer id){

		// get the student by id
		Student student = studentDAO.findById(id);

		// update the student
		student.setFirstName("Carlos");

		// save the student
		studentDAO.update(student);

		// display the student
		System.out.println("Updated student: " + student);
	}

	private void deleteById(StudentDAO studentDAO, Integer id){

		// display the student
		System.out.println("Deleting student with id: " + id);

		// delete student by id
		studentDAO.deleteById(id);
	}

	private void deleteAll(StudentDAO studentDAO){

		// delete student by last name
		int deletedStudents = studentDAO.deleteAll();

		// display the number of deleted students
		System.out.println("Number of deleteded students: " + deletedStudents);
	}
}
