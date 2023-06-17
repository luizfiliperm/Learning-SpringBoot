package com.luv2code.cruddemo.services;

import java.util.List;

import com.luv2code.cruddemo.entities.Employee;

public interface EmployeeService {
    
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
    
}
