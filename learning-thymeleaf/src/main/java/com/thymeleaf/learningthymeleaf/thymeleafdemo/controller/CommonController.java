package com.thymeleaf.learningthymeleaf.thymeleafdemo.controller;


import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.StudentRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.dao.TutorRepository;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Student;
import com.thymeleaf.learningthymeleaf.thymeleafdemo.model.Tutor;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommonController {
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
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
        return  "redirect:/tutor-login";
    }

    @GetMapping("/student-signup")
    public String signupStudent(ModelMap modelMap){
        modelMap.addAttribute("student",new Student());
        return "student-signup";
    }
    @PostMapping("/student-signup")
    public String signupStudent(@ModelAttribute("student") Student student){
        studentRepository.save(student);
        return  "redirect:/student-login";
    }
    @GetMapping("/student-login")
    public String loginStudent(){
        return "student-login";
    }
    @GetMapping("/tutor-login")
    public String loginTotor(){
        return "tutor-login";
    }
    @PostMapping("/student-login")
    public String loginStudent(@RequestParam String email, @RequestParam String password,ModelMap modelMap){
        Student student = studentRepository.findByStudentEmail(email);
        //System.out.println(student.getStudentEmail()+",,,,"+student.getStudetPassword());
        if(student==null || !student.getStudetPassword().equals(password)){
            return "redirect:/student-login";
        }
        if(student.getStudentEmail().equals(email) && student.getStudetPassword().equals(password)){
            modelMap.addAttribute("studentId", student.getStudentId());
            return "student";
        }
        return "redirect:/student-login";
    }
    @PostMapping("/tutor-login")
    public String loginTutor(@RequestParam String email, @RequestParam String password, HttpSession session){
        Tutor tutor = tutorRepository.findByTutorEmail(email);
        if(tutor==null){
            System.out.println("is null");
            return "redirect:/tutor-login";
        }
        if(tutor.getTutorEmail().equals(email) && tutor.getTutroPassword().equals(password)){
            session.setAttribute("tutorId",tutor.getTutorId());
            return "redirect:/tutor";
        }
        return "redirect:/tutor-login";
    }

}
