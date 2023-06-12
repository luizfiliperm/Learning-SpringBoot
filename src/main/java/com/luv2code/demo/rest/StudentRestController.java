package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entities.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the sutdent data ... only once

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));

        return students;
    }


    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // index into the list

        // check the studentId against list size
        if(studentId >= students.size() || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

    // add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
