package com.example.demo.configuration;

import com.example.demo.model.Classroom;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.ClassroomRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.sql.Date;
import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    @Order(value = 4)
    CommandLineRunner teacherCommandLineRunner(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        return args -> {
//            Course c1 = new Course();
//            c1.setCode("course01");
////            Course c2 = courseRepository.findById(2).orElseThrow(() -> new IllegalStateException("Not Found"));
////            Course c3 = courseRepository.findById(3).orElseThrow(() -> new IllegalStateException("Not Found"));
//            Teacher t1 = new Teacher();
//            t1.setName("teacher01");
//            t1.setCourse(c1);
//            c1.setTeacher(t1);
////            Teacher t2 = new Teacher("Teacher02", c2);
////            Teacher t3 = new Teacher("Teacher03", c3);
//            teacherRepository.save(t1);
//            courseRepository.save(c1);
        };
    }
}
