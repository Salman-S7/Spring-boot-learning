package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.CourseRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.TutorRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Course;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Tutor;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TutorController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @GetMapping("/tutor")
    public String addCourse(ModelMap modelMap) {
        modelMap.addAttribute("Course", new Course());
        return "tutor";
    }
    @PostMapping("/tutor")
    public String addCourse(@ModelAttribute("Course") Course course, @RequestParam("tutorId") Long tutorId) {
        System.out.println(tutorId);
        Tutor tutor = tutorRepository.findById(tutorId).get();
        course.setTutor(tutor);
        courseRepository.save(course);
        return "dashboard";
    }
}
