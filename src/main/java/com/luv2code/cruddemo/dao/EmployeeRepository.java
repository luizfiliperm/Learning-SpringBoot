package com.luv2code.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
