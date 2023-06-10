package com.luv2code.cruddemo.dao;


import java.util.List;

import com.luv2code.cruddemo.entities.Student;

public interface StudentDAO {
    
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
