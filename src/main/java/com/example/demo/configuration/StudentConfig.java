package com.example.demo.configuration;

import com.example.demo.model.Classroom;
import com.example.demo.model.Student;
import com.example.demo.repository.ClassroomRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.sql.Date;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    @Order(value = 2)
    CommandLineRunner studentCommandLineRunner(StudentRepository studentRepository, ClassroomRepository classroomRepository) {
        return args -> {
//            Classroom c = classroomRepository.findById(1).orElseThrow(() -> new IllegalStateException("Not Found"));
//            Student Long1 = new Student("Long1", Date.valueOf("2000-01-01"), "0123345567", c);
//            Student Long2 = new Student("Long2", Date.valueOf("2000-01-01"), "0123345567", c);
//            Student Long3 = new Student("Long3", Date.valueOf("2000-01-01"), "0123345567", c);
//            Student Long4 = new Student("Long4", Date.valueOf("2000-01-01"), "0123345567", c);
//            Student Long5 = new Student("Long5", Date.valueOf("2000-01-01"), "0123345567", c);
//            studentRepository.saveAll(List.of(Long1, Long2, Long3, Long4, Long5));
        };
    }
}
