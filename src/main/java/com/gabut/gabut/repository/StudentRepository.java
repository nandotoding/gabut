package com.gabut.gabut.repository;

import com.gabut.gabut.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT * FROM students", nativeQuery = true)
    List<Student> getAllStudents();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO students (nim, name, school_name) VALUES (:nim, :name, :schoolName)", nativeQuery = true)
    void addStudent(@Param("nim") String nim, @Param("name") String name, @Param("schoolName") String schoolName);
}
