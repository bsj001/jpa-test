package com.example.jpatest.student.application.service;


import com.example.jpatest.student.domain.model.*;
import com.example.jpatest.student.domain.service.StudentDomainService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Page<StudentAndSchoolInfo> listStudentAndSchool4(List<Integer> ids, String name) {
        return studentDomainService.listStudentAndSchool4(ids,name);
    }
}
