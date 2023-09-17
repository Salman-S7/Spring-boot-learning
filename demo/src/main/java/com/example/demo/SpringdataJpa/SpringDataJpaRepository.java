package com.example.demo.SpringdataJpa;

import com.example.demo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Course, Long> {
    public List<Course> findByName(String name);
}
