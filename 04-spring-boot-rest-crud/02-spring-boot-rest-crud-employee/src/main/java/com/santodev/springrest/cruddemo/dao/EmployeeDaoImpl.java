package com.santodev.springrest.cruddemo.dao;

import com.santodev.springrest.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    // define field for EntityManager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // return query results
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        // save OR update employee
        Employee employee1 = entityManager.merge(employee);         // if id == 0 -> insert else update

        // return employee (updated id)
        return employee1;
    }

    @Override
    public void deleteById(int id) {
        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        // delete employee
        entityManager.remove(employee);
    }
}
