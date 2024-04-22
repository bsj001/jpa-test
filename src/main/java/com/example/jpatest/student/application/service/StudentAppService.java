package com.example.jpatest.student.application.service;


import com.example.jpatest.student.domain.model.SsDto;
import com.example.jpatest.student.domain.model.SsDto2;
import com.example.jpatest.student.domain.model.SsDto3;
import com.example.jpatest.student.domain.model.Student;
import com.example.jpatest.student.domain.service.StudentDomainService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentAppService {
    
    private StudentDomainService studentDomainService;
    
    @Autowired
    public void setStudentDomainService(StudentDomainService studentDomainService){
        this.studentDomainService = studentDomainService;
    }
    
    //@Transactional
    public List<Student> query() {
        return studentDomainService.query();
    }

    public List<SsDto> listStudentAndSchool() {
        return studentDomainService.listStudentAndSchool();
    }

    public List<SsDto2> listStudentAndSchool2() {
        return studentDomainService.listStudentAndSchool2();
    }

    public List<SsDto3> listStudentAndSchool3() {
        return studentDomainService.listStudentAndSchool3().stream().map(SsDto3::new).collect(Collectors.toList());
    }
}
