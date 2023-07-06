package com.luv2code.cruddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.CourseRepository;
import com.luv2code.cruddemo.dao.InstructorDetailRepository;
import com.luv2code.cruddemo.dao.InstructorRepository;
import com.luv2code.cruddemo.entities.Course;
import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository, CourseRepository courseRepository){
		return runner ->{
			// createInstructor(instructorRepository);

			// fidInstructorDetailById(1L, instructorDetailRepository);

			// deleteInstructorDetailById(3L, instructorDetailRepository, instructorRepository);

			// System.out.println(instructorRepository.findById(3L));

			// createInstructorAndAddCourses(instructorRepository);

			// addCourseToAExistingInstructor(1L, instructorRepository);

			printInstructorWithCourses(1L, instructorRepository);
			
		};
	}

	private void createInstructor(InstructorRepository instructorRepository){
		Instructor instructor = new Instructor("Luiz", "Filipe", "luiz@gmail.com", null);

		InstructorDetail instructorDetail = new InstructorDetail("luizfilipe", "Guittar");

		instructor.setInstructorDetail(instructorDetail);

		instructorRepository.save(instructor);
		System.out.println("Instructor save: " + instructor);
	}

	private void fidInstructorDetailById(Long id, InstructorDetailRepository instructorDetailRepository){
		Optional<InstructorDetail> instructorDetailData = instructorDetailRepository.findById(id);

		if(instructorDetailData.isPresent()){
			InstructorDetail instructorDetail = instructorDetailData.get();
			System.out.println(instructorDetail);

			System.out.println(instructorDetail.getInstructor());
		}
	}

	private void deleteInstructorDetailById(Long id, InstructorDetailRepository instructorDetailRepository, InstructorRepository instructorRepository) {
    Optional<InstructorDetail> instructorDetailData = instructorDetailRepository.findById(id);
    
		if (instructorDetailData.isPresent()) {
			InstructorDetail instructorDetail = instructorDetailData.get();
			Instructor instructor = instructorDetail.getInstructor();
			
			if (instructor != null) {
				instructor.setInstructorDetail(null);
				instructorRepository.save(instructor);
			}
			
			instructorDetailRepository.deleteById(id);
			System.out.println("InstructorDetail removido com sucesso.");
		} else {
			System.out.println("InstructorDetail não encontrado.");
		}
	}
	
	private void createInstructorAndAddCourses(InstructorRepository instructorRepository){

		Instructor instructor = new Instructor("Luiz", "Filipe", "luizfilipe@gmail.com", new InstructorDetail("youtube.com", "Code"));

		Course course = new Course("All about OOP");

		instructor.add(course);

		System.out.println("Adding new Instructor: " + instructor);
		System.out.println("Adding new Course: " + course);
		instructorRepository.save(instructor);

		System.out.println("done");
	}

	private void addCourseToAExistingInstructor(Long instructorID, InstructorRepository instructorRepository){
		Instructor instructor = instructorRepository.findById(instructorID).get();

		Course course = new Course("All about Spring");

		instructor.add(course);

		System.out.println("Adding this course: " + course);
		System.out.println("To this instructor: " + instructor);
		instructorRepository.save(instructor);

		System.out.println("Done!");
	}

	// Eager Way
	/*
	private void printInstructorWithCourses(Long id, InstructorRepository instructorRepository){
		Instructor instructor = instructorRepository.findById(id).get();

		System.out.println(instructor);

		System.out.println("Courses: " + instructor.getCourses());
	} 
	*/

	// Lazy Way
	// private void printInstructorWithCourses(Long id, InstructorRepository instructorRepository, CourseRepository courseRepository){
	// 	Instructor instructor = instructorRepository.findById(id).get();

	// 	System.out.println(instructor);

	// 	List<Course> courses = courseRepository.findByInstructorId(id);

	// 	instructor.setCourses(courses);

	// 	System.out.println("Courses: " + instructor.getCourses());
	// } 

	// Another Lazy Way Using Join Query
	private void printInstructorWithCourses(Long id, InstructorRepository instructorRepository){
		Instructor instructor = instructorRepository.findByIdAndFetchCoursesEagerly(id);

		System.out.println(instructor);

		System.out.println("Courses: " + instructor.getCourses());
	} 
}
