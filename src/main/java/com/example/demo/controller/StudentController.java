package com.example.demo.controller;

import com.example.demo.model.Classroom;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public List<Student> getStudent() {
        return studentService.getStudents();
    }

    @PostMapping("/addNew")
    public void addStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void delStudent(@PathVariable("studentId") int studentId) {
        studentService.delStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") int studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Date dob,
            @RequestParam(required = false) String phone
            ) {
        studentService.updateStudent(studentID, name, dob, phone);
    }

    @GetMapping("/likeCourse")
    public void regisToCourse() {
        Course c1 = new Course("CourseA");
        Course c2 = new Course("CourseB");

        Student student = new Student("Longzxc", Date.valueOf("2000-01-01"), "01233454567");

        Set<Course> courseSet = new HashSet<>();
        courseSet.add(c1);
        courseSet.add(c2);

        student.setLikedCourses(courseSet);

        studentService.addNewStudent(student);
    }
}
