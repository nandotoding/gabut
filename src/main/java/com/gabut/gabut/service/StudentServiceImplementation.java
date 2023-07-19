package com.gabut.gabut.service;

import com.gabut.gabut.model.Student;
import com.gabut.gabut.model.StudentRequest;
import com.gabut.gabut.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImplementation(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = repository.getAllStudents();
        return students;
    }

    @Override
    public void addStudent(StudentRequest request) {
        Student student = new Student();
        student.setNim(request.getNim());
        student.setName(request.getName());
        student.setSchoolName(request.getSchoolName());

        repository.save(student);
    }

}
