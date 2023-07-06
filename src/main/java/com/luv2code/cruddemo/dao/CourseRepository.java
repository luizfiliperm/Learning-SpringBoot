package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemo.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
    List<Course> findByInstructorId(Long id);
}
