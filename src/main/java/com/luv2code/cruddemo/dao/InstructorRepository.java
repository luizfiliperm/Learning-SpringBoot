package com.luv2code.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemo.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
}
