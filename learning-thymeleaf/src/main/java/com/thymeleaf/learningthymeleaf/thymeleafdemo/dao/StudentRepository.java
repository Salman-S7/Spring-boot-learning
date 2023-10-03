package com.thymeleaf.learningthymeleaf.thymeleafdemo.dao;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByStudentEmail(String email);
}
