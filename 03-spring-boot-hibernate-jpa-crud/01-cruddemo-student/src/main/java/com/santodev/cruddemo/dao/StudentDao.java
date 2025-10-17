package com.santodev.cruddemo.dao;

import com.santodev.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    int updateAll();
    void delete(Integer id);
    int deleteAll();
}
