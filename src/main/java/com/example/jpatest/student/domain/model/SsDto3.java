package com.example.jpatest.student.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class SsDto3 implements Serializable {

    @Serial
    private static final long serialVersionUID = -7242005560621561107L;
    
    private String schoolName;
    
    private String name;

    public SsDto3(Map map) {
        this.schoolName = (String) map.get("schoolName");
        this.name = (String) map.get("name");
    }
    
    
}
