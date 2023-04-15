package com.example.demo.controller;

import com.example.demo.model.Classroom;
import com.example.demo.model.Course;
import com.example.demo.service.ClassroomService;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourse() {
        return courseService.getCourse();
    }

    @PostMapping
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void delCourse(@PathVariable("courseId") int courseId) {
        courseService.deleteCourse(courseId);
    }

    @PutMapping(path = "{courseId}")
    public void updateCourse(
            @PathVariable("courseId") int courseId,
            @RequestParam(required = false) String code
    ) {
        courseService.updateCourse(courseId, code);
    }
}
