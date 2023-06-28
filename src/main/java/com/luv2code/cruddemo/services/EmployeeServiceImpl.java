package com.luv2code.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        
        Optional<Employee> result = employeeRepository.findById(id);

        if(!result.isPresent()){
            throw new RuntimeException("Did not find employee id - " + id);
        }
        
        Employee employee = result.get();

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
    
}
