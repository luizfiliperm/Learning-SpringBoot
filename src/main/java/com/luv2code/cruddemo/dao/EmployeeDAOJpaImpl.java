package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;


    // @Autowired is optional for constructors
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }
    
}
