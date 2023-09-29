package com.thymeleaf.learningthymeleaf.thymeleafdemo.model;

import java.util.List;

public class Tutor {
    private int tutorId;
    private String tutorName;
    private String tutorEmail;
    private String tutorPhone;
    private String tutroPassword;
    private List<Course> courseList;

    public Tutor(){
    }

    public Tutor(int tutorId, String tutorName, String tutorEmail, String tutorPhone, String tutroPassword, List<Course> courseList) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.tutorPhone = tutorPhone;
        this.tutroPassword = tutroPassword;
        this.courseList = courseList;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
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

    public String getTutorPhone() {
        return tutorPhone;
    }

    public void setTutorPhone(String tutorPhone) {
        this.tutorPhone = tutorPhone;
    }

    public String getTutroPassword() {
        return tutroPassword;
    }

    public void setTutroPassword(String tutroPassword) {
        this.tutroPassword = tutroPassword;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
