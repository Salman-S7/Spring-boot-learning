package com.thymeleaf.learningthymeleaf.thymeleafdemo.dao;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    Tutor findByTutorEmail(String email);
}
