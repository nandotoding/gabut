package com.gabut.gabut.service;

import com.gabut.gabut.model.Student;
import com.gabut.gabut.model.StudentRequest;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void addStudent(StudentRequest request);
}
