package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not Found!"));
    }

    public void addCourse(Course course) {
        Optional<Course> courseOptional= courseRepository.findCoursesByCode(course.getCode());

        if (courseOptional.isPresent()) {
            throw new IllegalStateException("Code Exists");
        }
        courseRepository.save(course);
    }

    public void deleteCourse(int courseId) {
        boolean exists = courseRepository.existsById(courseId);
        if (!exists) {
            throw new IllegalStateException("Course with Id = " + courseId + " does not exists!");
        }
        courseRepository.deleteById(courseId);
    }

    public void updateCourse(int courseId, String code) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalStateException("Course with Id = " + courseId + " does not exists!"));
        if (code != null && !code.isEmpty()) {
            course.setCode(code);
        }
    }
}
