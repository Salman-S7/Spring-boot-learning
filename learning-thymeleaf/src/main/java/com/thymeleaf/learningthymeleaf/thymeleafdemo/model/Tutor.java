package com.thymeleaf.learningthymeleaf.thymeleafdemo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tutorId;
    private final String role = "ROLE_TUTOR";
    private String tutorName;
    private String tutorEmail;
    private String tutorUserName;
    private String tutroPassword;
    @OneToMany(mappedBy ="tutor")
    private Set<Course> courseSet;

    public Tutor(){
    }

    public Tutor(long tutorId, String tutorName, String tutorEmail, String tutroPassword, Set<Course> courseSet) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.tutroPassword = tutroPassword;
        this.courseSet = courseSet;
    }

    public long getTutorId() {
        return tutorId;
    }

    public void setTutorId(long tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public String getTutroPassword() {
        return tutroPassword;
    }

    public void setTutroPassword(String tutroPassword) {
        this.tutroPassword = tutroPassword;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public String getTutorUserName() {
        return tutorUserName;
    }

    public void setTutorUserName(String tutorUserName) {
        this.tutorUserName = tutorUserName;
    }
}
