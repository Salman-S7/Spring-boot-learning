package com.thymeleaf.learningthymeleaf.thymeleafdemo.dao;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
}
