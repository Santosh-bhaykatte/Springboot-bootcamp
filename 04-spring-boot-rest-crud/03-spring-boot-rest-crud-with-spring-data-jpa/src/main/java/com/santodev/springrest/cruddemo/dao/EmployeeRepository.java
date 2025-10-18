package com.santodev.springrest.cruddemo.dao;

import com.santodev.springrest.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No need to write any code... LOL!
}
