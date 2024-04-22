package com.example.jpatest.school.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("CitySchool")
public class CitySchool extends School{

    @Column(name="city_name",columnDefinition = "varchar(255)")
    private String cityName;
    
}
