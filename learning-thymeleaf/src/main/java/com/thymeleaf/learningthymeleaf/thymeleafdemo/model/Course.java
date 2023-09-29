package com.thymeleaf.learningthymeleaf.thymeleafdemo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;
    private String courseTitle;
    private String courseDescription;
    private double coursePrice;
    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet;

    public Course() {
    }

    public Course(long courseId, String courseTitle, String courseDescription, double coursePrice, Tutor tutor, Set<Student> studentSet) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.coursePrice = coursePrice;
        this.tutor = tutor;
        this.studentSet = studentSet;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
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

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
