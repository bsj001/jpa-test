package com.example.jpatest.school.repository;

import com.example.jpatest.school.domain.model.CitySchool;
import com.example.jpatest.school.domain.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSchoolRepository extends JpaRepository<School,Integer> {
    List<CitySchool> findByCityName(String cityName);
}
