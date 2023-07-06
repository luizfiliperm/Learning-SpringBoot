package com.luv2code.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
}
