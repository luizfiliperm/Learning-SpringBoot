package com.luv2code.cruddemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO employeeDAO;


    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
    
}
