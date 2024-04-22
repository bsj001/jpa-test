package com.example.jpatest.student.domain.model;

import com.example.jpatest.school.domain.model.School;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SsDto2 implements Serializable {

    @Serial
    private static final long serialVersionUID = -7242005560621561107L;
    
    private String schoolName;
    
    private String name;

    public SsDto2(String schoolName, String name) {
        this.schoolName = schoolName;
        this.name = name;
    }
    
    
}
