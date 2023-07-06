package com.luv2code.cruddemo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.InstructorDetailRepository;
import com.luv2code.cruddemo.dao.InstructorRepository;
import com.luv2code.cruddemo.entities.Instructor;
import com.luv2code.cruddemo.entities.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository){
		return runner ->{
			// createInstructor(instructorRepository);
			// fidInstructorDetailById(1L, instructorDetailRepository);
			deleteInstructorDetailById(3L, instructorDetailRepository, instructorRepository);
			System.out.println(instructorRepository.findById(3L));
			
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

}
