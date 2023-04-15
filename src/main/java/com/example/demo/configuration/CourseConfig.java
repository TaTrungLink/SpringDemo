package com.example.demo.configuration;

import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class CourseConfig {
//    @Bean
//    @Order(value = 3)
//    CommandLineRunner courseCommandlineRunner(CourseRepository courseRepository) {
//        return args -> {
////            Course c1 = new Course("Course01");
////            Course c2 = new Course("Course02");
////            Course c3 = new Course("Course03");
////            courseRepository.saveAll(List.of(c1, c2, c3));
//        };
//    }
}
