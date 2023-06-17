package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entities.Employee;

public interface EmployeeDAO {
    
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
