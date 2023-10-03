package com.thymeleaf.learningthymeleaf.thymeleafdemo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private String studetPassword;
    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courseSet;

    public Student() {
    }

    public Student(long studentId, String studentName, String studentEmail, String studentPhone, Set<Course> courseList,String studentPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.courseSet = courseList;
        this.studetPassword = studentPassword;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }
    public String getStudetPassword() {
        return studetPassword;
    }
    public void setStudetPassword(String studetPassword) {
        this.studetPassword = studetPassword;
    }
}
