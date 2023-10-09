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
import java.util.Set;

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
    @GetMapping("/student")
    public String getStudentPage(){
        return "student";
    }
    @GetMapping("/courses")
    public String getAllCourses(@RequestParam long studentId,ModelMap modelMap,HttpSession session){
        List<Course> allCourses = courseRepository.findAll();
        modelMap.addAttribute("courses", allCourses);
        System.out.println(studentId);
        session.setAttribute("studentId",studentId);
        return "courses";
    }
    @GetMapping("/buycourse")
    public String buyCourse(@RequestParam long courseId,@RequestParam long studentId,HttpSession session){
        Course course = courseRepository.findById(courseId).get();
        //long studentId = (long)session.getAttribute("studentId");

        Student student = studentRepository.findById(studentId).get();
        student.getCourseSet().add(course);
        course.getStudentSet().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
        return "student";
    }
    @GetMapping("/boughtCourses")
    public String seeBoughtCourses(@RequestParam long studentId,ModelMap modelMap){
        Student student = studentRepository.findById(studentId).get();
        Set<Course> boughtCourses = student.getCourseSet();
        modelMap.addAttribute("boughtCourses", boughtCourses);
        return "boughtCourses";
    }
}
