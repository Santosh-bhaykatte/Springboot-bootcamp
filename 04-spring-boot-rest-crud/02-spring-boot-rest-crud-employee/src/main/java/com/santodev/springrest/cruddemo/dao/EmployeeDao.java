package com.santodev.springrest.cruddemo.dao;

import com.santodev.springrest.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
