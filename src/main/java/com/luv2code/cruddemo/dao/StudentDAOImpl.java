package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection

    // @Autowired - Optional for constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // implement findById method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }


    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }


    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);

        // set query parameters
        query.setParameter("data", lastName);

        // return the results
        return query.getResultList();
    }

}
