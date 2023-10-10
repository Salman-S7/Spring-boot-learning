package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.CourseRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.TutorRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Course;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

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
        Tutor tutor = tutorRepository.findById(tutorId).get();
        course.setTutor(tutor);
        courseRepository.save(course);
        return "dashboard";
    }

    @GetMapping("/mycourses")
    public String myCourses(@RequestParam long tutorId,ModelMap modelMap){
        Tutor tutor = tutorRepository.findById(tutorId).get();
        Set<Course> courses = tutor.getCourseSet();
        modelMap.addAttribute("courses",courses);
        return "mycourses";
    }

    //still need to update the course
    @GetMapping("update")
    public String updateCourse(@RequestParam long courseId, ModelMap model){
        Course course = courseRepository.findById(courseId).get();
        model.addAttribute("Course",course);
        return "tutor";
    }
}
