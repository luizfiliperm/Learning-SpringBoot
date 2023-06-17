package com.luv2code.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entities.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeDAO employeeDAO;

    // inject the employee dao

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
    
}
