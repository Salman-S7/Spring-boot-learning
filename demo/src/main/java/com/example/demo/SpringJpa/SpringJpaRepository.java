package com.example.demo.SpringJpa;

import com.example.demo.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringJpaRepository {
    @Autowired
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course getById(int id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
