package com.santodev.cruddemo.dao;

import com.santodev.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    // define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement methods
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);       // find by primary key
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s where s.lastName=:lastName", Student.class);

        // set query parameters
        query.setParameter("lastName", lastName);

        // return query ressults
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateAll() {
        // create query
        Query query = entityManager.createQuery("UPDATE Student s SET s.status=:status WHERE s.lastName=:lastName");

        // set query parameters
        query.setParameter("status", "active");
        query.setParameter("lastName", "stark");

        // execute query
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve student by id
        Student student = findById(id);

        // delete student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Student WHERE lastName LIKE 'b%'");
        return query.executeUpdate();
    }
}
