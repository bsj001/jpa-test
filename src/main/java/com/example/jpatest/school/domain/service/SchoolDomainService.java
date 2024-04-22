package com.example.jpatest.school.domain.service;

import com.example.jpatest.school.domain.model.CitySchool;
import com.example.jpatest.school.domain.model.School;
import com.example.jpatest.school.repository.JpaSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDomainService {

    private JpaSchoolRepository jpaSchoolRepository;
    
    @Autowired
    public void setJpaSchoolRepository(JpaSchoolRepository jpaSchoolRepository){
        this.jpaSchoolRepository = jpaSchoolRepository;
    }
    public List<School> query() {
        return jpaSchoolRepository.findAll();
    }

    public List<CitySchool> findByCityName(String cityName) {
        return jpaSchoolRepository.findByCityName(cityName);
    }
}
