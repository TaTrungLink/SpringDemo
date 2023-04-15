package com.example.demo.controller;

import com.example.demo.service.ClassroomService;
import com.example.demo.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public List<Classroom> getClassroom() {
        return classroomService.getClassrooms();
    }

    @PostMapping
    public void addClassroom(@RequestBody Classroom classroom) {
        classroomService.addNewClassroom(classroom);
    }

    @DeleteMapping(path = "{classroomId}")
    public void delClassroom(@PathVariable("classroomId") int clasroomId) {
        classroomService.deleteClassroom(clasroomId);
    }

    @PutMapping(path = "{classroomId}")
    public void updateClassroom(
            @PathVariable("classroomId") int classroomId,
            @RequestParam(required = false) String code
    ) {
        classroomService.updateClassroom(classroomId, code);
    }
}
