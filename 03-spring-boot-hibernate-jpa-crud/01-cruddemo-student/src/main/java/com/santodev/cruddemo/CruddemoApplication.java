package com.santodev.cruddemo;

import com.santodev.cruddemo.dao.StudentDao;
import com.santodev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    // executed after the spring beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
//            createStudent(studentDao);
            createMultipleStudents(studentDao);
//            getStudentById(studentDao);
//            getAllStudents(studentDao);
//            getStudentByLastName(studentDao);
//            updateStudent(studentDao);
//            updateAllStudents(studentDao);
//            deleteStudent(studentDao);
//            deleteAll(studentDao);
        };
    }

    private void deleteAll(StudentDao studentDao) {
        // deleting students
        System.out.println("Deleting students...");
        int rowsDeleted = studentDao.deleteAll();

        System.out.println("Deleted students: "+ rowsDeleted);
    }

    private void deleteStudent(StudentDao studentDao) {
        // delete stuent by id
        System.out.println("Deleting student with ID: "+ 3);
        studentDao.delete(3);
    }

    private void updateAllStudents(StudentDao studentDao) {
        // update all records
        System.out.println("Updating students...");
        int rowsUpdated = studentDao.updateAll();

        // display updated records
        System.out.println("Updated Students: "+ rowsUpdated);
        getAllStudents(studentDao);
    }

    private void updateStudent(StudentDao studentDao) {
        // get student by id to update
        System.out.println("Getting student with ID: 1");
        Student student = studentDao.findById(1);

        // update fields
        System.out.println("Updating student...");
        student.setFirstName("scooby");

        // update the student
        studentDao.update(student);

        // display updated student
        System.out.println("Updated student: "+ student);
    }

    private void getStudentByLastName(StudentDao studentDao) {
        // fetch student record matching last name
        System.out.println("fetching student records...");
        List<Student> students = studentDao.findByLastName("stark");

        // display students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void getAllStudents(StudentDao studentDao) {
        // retrieving all students
        System.out.println("fetching student records...");
        List<Student> students = studentDao.findAll();

        // display students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void getStudentById(StudentDao studentDao) {
        // retrieving student by id
        System.out.println("fetching student record...");
        Student student = studentDao.findById(2);

        if (student != null) {
            System.out.println("Student Found: "+ student);
        } else {
            System.out.println("Student not exists");
        }
    }

    private void createMultipleStudents(StudentDao studentDao) {
        // create multiple students
        System.out.println("creating 3 student objects...");
        Student student1 = new Student("ramsay", "bolton", "ramsay@gmail.com");
        Student student2 = new Student("bran", "builder", "bran@gmail.com");
        Student student3 = new Student("thoros", "meyr", "thoros@gmail.com");

        // save student objects
        System.out.println("saving students...");
        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
    }

    private void createStudent(StudentDao studentDao) {
        // create student bean
        System.out.println("creating student...");
        Student student = new Student("Tony", "Stark", "tony@gmail.com");

        // save student bean
        System.out.println("saving student...");
        studentDao.save(student);

        // display id of saved student
        System.out.println("Saved student ID: "+ student.getId());
    }

}
