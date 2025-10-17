package com.santodev.springrest.rest;

import com.santodev.springrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // define field
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("tony", "stark"));
        students.add(new Student("john", "snow"));
        students.add(new Student("roose", "bolton"));
    }

    // expose endpoint "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
}
