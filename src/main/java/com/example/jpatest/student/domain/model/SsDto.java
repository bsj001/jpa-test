package com.example.jpatest.student.domain.model;

import com.example.jpatest.school.domain.model.School;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SsDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -7242005560621561106L;
    
    private School school;
    
    private Student student;

    public SsDto(School school, Student student) {
        this.school = school;
        this.student = student;
    }
    
    
}
