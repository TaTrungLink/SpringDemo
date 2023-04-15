package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clasroom_id")
    private int id;
    @Column(name = "classroom_code")
    private String code;

    public Classroom(String code) {
        this.code = code;
    }

    @OneToMany(
            mappedBy = "classroom",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> students;
}
