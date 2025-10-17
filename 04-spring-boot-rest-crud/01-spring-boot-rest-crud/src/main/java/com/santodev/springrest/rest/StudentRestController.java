package com.santodev.springrest.rest;

import com.santodev.springrest.entity.Student;
import com.santodev.springrest.other.StudentErrorResponse;
import com.santodev.springrest.other.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // expose endpoint "/students/{id}" - return student at index
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {

        // throw exception - if id out of range
        if (id >= students.size() || id < 0) {
            throw new StudentNotFoundException("Student id not found: "+ id);
        }

        return students.get(id);
    }

    // exception handler method
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        // create StudentErrorResponse object
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
        // create StudentErrorResponse object
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
