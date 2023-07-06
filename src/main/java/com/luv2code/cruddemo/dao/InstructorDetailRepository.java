package com.luv2code.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemo.entities.InstructorDetail;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
    
}
