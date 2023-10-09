package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.CourseRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.StudentRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Course;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
   /* public StudentController(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }*/

    public StudentController() {
    }

    @GetMapping("/courses")
    public String getAllCourses(ModelMap modelMap){
        List<Course> allCourses = courseRepository.findAll();
        modelMap.addAttribute("courses", allCourses);
        return "courses";
    }
    @GetMapping("/buycourse")
    public String buyCourse(@RequestParam long courseId, HttpSession session){
        Course course = courseRepository.findById(courseId).get();
        //long studentId = (long)session.getAttribute("studentId");
        long studentId = 2;
        Student student = studentRepository.findById(studentId).get();
        student.getCourseSet().add(course);
        course.getStudentSet().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
        return "student";
    }
}
