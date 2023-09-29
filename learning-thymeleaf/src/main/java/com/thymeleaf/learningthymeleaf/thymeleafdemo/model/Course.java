package com.thymeleaf.learningthymeleaf.thymeleafdemo.model;

import java.util.List;

public class Course {
    private int courseId;
    private String courseTitle;
    private String courseDescription;
    private double coursePrice;
    private Tutor tutor;
    private List<Student> studentList;

    public Course() {
    }

    public Course(int courseId, String courseTitle, String courseDescription, double coursePrice, Tutor tutor, List<Student> studentList) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.coursePrice = coursePrice;
        this.tutor = tutor;
        this.studentList = studentList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
