package com.luv2code.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luv2code.cruddemo.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
    @Query("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = (:id)")
    public Instructor findByIdAndFetchCoursesEagerly(@Param("id") Long id);


}
