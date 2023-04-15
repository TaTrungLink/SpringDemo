package com.example.demo.configuration;

import com.example.demo.repository.ClassroomRepository;
import com.example.demo.model.Classroom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class ClassroomConfig {
    @Bean
    @Order(value = 1)
    CommandLineRunner classroomCommandLineRunner(ClassroomRepository repository) {
        return args -> {
//            Classroom c1 = new Classroom("C01");
//            Classroom c2 = new Classroom("C01");
//            Classroom c3 = new Classroom("C01");
//            repository.saveAll(List.of(c1, c2, c3));
        };
    }
}
