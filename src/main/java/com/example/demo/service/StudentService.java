package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void delStudent(int id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with Id = " + id + " does not exists!");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(int id, String name, Date dob, String phone) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with Id = " + id + " does not exists!"));
        if (name != null && !name.isEmpty()) {
            student.setName(name);
        }
        if (dob != null) {
            student.setDob(dob);
        }
        if (phone != null && !phone.isEmpty()) {
            student.setPhone(phone);
        }
    }
}
