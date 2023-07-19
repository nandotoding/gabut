package com.gabut.gabut.controller;

import com.gabut.gabut.model.Student;
import com.gabut.gabut.model.StudentRequest;
import com.gabut.gabut.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentRequest request) {
        service.addStudent(request);
        return ResponseEntity.status(HttpStatus.OK).body("Student data added successfully.");
    }

}
