package com.example.jpatest.student.adapter.controller;


import com.example.jpatest.student.application.service.StudentAppService;
import com.example.jpatest.student.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("school/student")
@RestController
public class StudentController {

    private StudentAppService studentAppService;

    @Autowired
    public void setStudentAppService(StudentAppService studentAppService) {
        this.studentAppService = studentAppService;
    }


    //@RequestMapping(value="list",method = RequestMethod.POST)
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Student> listStudent() {
        return studentAppService.query();
    }

    @RequestMapping(value = "listStudentAndSchool", method = RequestMethod.GET)
    public List<SsDto> listStudentAndSchool() {
        return studentAppService.listStudentAndSchool();
    }

    @RequestMapping(value = "listStudentAndSchool2", method = RequestMethod.GET)
    public List<SsDto2> listStudentAndSchool2() {
        return studentAppService.listStudentAndSchool2();
    }


    @RequestMapping(value = "listStudentAndSchool3", method = RequestMethod.GET)
    public List<SsDto3> listStudentAndSchool3() {
        return studentAppService.listStudentAndSchool3();
    }

    @RequestMapping(value = "listStudentAndSchool4", method = RequestMethod.GET)
    public Page<StudentAndSchoolInfo> listStudentAndSchool4(@RequestParam(value = "ids", required = false) List<Integer> ids, @RequestParam(value = "name", required = false) String name) {
        return studentAppService.listStudentAndSchool4(ids, name);
    }

}
