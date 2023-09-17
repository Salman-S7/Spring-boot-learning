package com.example.demo.SpringdataJpa;

import com.example.demo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRepository extends JpaRepository<Course, Long> {
}
