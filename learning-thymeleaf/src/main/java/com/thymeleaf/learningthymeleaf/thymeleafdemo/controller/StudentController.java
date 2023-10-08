package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.CourseRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    private final CourseRepository courseRepository;
    public StudentController(CourseRepository courseRepository){
         this.courseRepository = courseRepository;
    }
    @GetMapping("/courses")
    public String getAllCourses(ModelMap modelMap){
        List<Course> allCourses = courseRepository.findAll();
        modelMap.addAttribute("courses", allCourses);
        return "courses";
    }
}
