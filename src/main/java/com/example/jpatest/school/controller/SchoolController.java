package com.example.jpatest.school.controller;


import com.example.jpatest.school.application.service.SchoolAppService;
import com.example.jpatest.school.domain.model.CitySchool;
import com.example.jpatest.school.domain.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {

    private SchoolAppService schoolAppService;

    @Autowired
    public void setSchoolAppService(SchoolAppService schoolAppService) {
        this.schoolAppService = schoolAppService;
    }

    @RequestMapping(value = "listSchool", method = RequestMethod.GET)
    public List<School> listSchool() {
        return schoolAppService.query();
    }

    @RequestMapping(value = "findByCityName", method = RequestMethod.GET)
    public List<CitySchool> findByCityName(@RequestParam("cityName") String cityName) {
        return schoolAppService.findByCityName(cityName);
    }
}
