package com.example.demo.service;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    public void addNewClassroom(Classroom c) {
        Optional<Classroom> classroomOptional= classroomRepository.findClassroomByCode(c.getCode());

        if (classroomOptional.isPresent()) {
            throw new IllegalStateException("Code Exists!");
        }
        classroomRepository.save(c);
    }

    public void deleteClassroom(int id) {
        boolean exists = classroomRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Classroom with Id = " + id + " does not exists!");
        }
        classroomRepository.deleteById(id);
    }

    @Transactional
    public void updateClassroom(int id, String code) {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(() -> new IllegalStateException("Classroom with Id = " + id + " does not exists!"));
        if (code != null && !code.isEmpty()) {
            classroom.setCode(code);
        }
    }
}
