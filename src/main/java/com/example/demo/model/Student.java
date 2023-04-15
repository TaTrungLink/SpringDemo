package com.example.demo.model;

import com.example.demo.model.Classroom;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_dob")
    private Date dob;
    @Column(name = "student_phone")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classroom_id")
    @JsonBackReference
    private Classroom classroom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> likedCourses;

    public Student(String name, Date dob, String phone) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
    }

    public Student(String name, Date dob, String phone, Classroom classroom) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.classroom = classroom;
    }

}
