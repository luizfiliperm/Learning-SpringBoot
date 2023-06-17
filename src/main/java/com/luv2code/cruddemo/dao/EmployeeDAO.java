package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entities.Employee;

public interface EmployeeDAO {
    
    List<Employee> findAll();
}
