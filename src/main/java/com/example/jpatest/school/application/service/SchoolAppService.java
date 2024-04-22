package com.example.jpatest.school.application.service;


import com.example.jpatest.school.domain.model.CitySchool;
import com.example.jpatest.school.domain.model.School;
import com.example.jpatest.school.domain.service.SchoolDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolAppService {
    
    private SchoolDomainService schoolDomainService;
    
    @Autowired
    public void setSchoolDomainService(SchoolDomainService schoolDomainService){
        this.schoolDomainService = schoolDomainService;
    }
    
    public List<School> query() {
        return schoolDomainService.query();
    }

    public List<CitySchool> findByCityName(String cityName) {
        return schoolDomainService.findByCityName(cityName);
    }
}
