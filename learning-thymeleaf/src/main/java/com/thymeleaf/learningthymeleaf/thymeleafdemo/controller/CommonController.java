package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;

import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.StudentRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.TutorRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Student;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Tutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommonController {
    private StudentRepository studentRepository;
    private TutorRepository tutorRepository;
    public CommonController(StudentRepository studentRepository,TutorRepository tutorRepository){
        this.studentRepository = studentRepository;
        this.tutorRepository = tutorRepository;
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/tutor-signup")
    public String signupTutor(ModelMap modelMap){
        modelMap.addAttribute("tutor",new Tutor());
        return  "tutor-signup";
    }
    @PostMapping("/tutor-signup")
    public String signupTutor(@ModelAttribute("tutor") Tutor tutor){
        tutorRepository.save(tutor);
        return  "redirect:/login";
    }
    @GetMapping("/student-signup")
    public String signupStudent(ModelMap modelMap){
        modelMap.addAttribute("student",new Student());
        return "student-signup";
    }
    @PostMapping("/student-signup")
    public String signupStudent(@ModelAttribute("student") Student student){
        studentRepository.save(student);
        return  "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        Student student = studentRepository.findByStudentEmail(email);
        System.out.println(student.getStudentEmail()+",,,,"+student.getStudetPassword());
        if(student==null || !student.getStudetPassword().equals(password)){
            return "redirect:/login";
        }
        if(student.getStudentEmail().equals(email) && student.getStudetPassword().equals(password)){
            return "dashboard";
        }
        return "redirect:/login";
    }

}
