package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Course;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private CourseService courseService;
    public StudentController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping("/courses")
    public String getAllCourses(ModelMap modelMap){
        List<Course> allCourses = courseService.findAll();
        modelMap.addAttribute("course", allCourses);
        return "Courses";
    }
}
