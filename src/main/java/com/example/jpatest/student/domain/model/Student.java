package com.example.jpatest.student.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int")
    private Integer id;
    
    @Column(columnDefinition = "varchar(255)")
    private String name;

    @Column(columnDefinition = "int")
    private Integer age;
    
    @Column(columnDefinition = "int")
    private Integer school_id;
    
}
