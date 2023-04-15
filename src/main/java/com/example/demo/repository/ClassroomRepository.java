package com.example.demo.repository;

import com.example.demo.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    @Query("SELECT c from Classroom c WHERE c.code = ?1")
    Optional<Classroom> findClassroomByCode(String code);
}
