package com.example.jpatest.school.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@DiscriminatorValue("ProvinceSchool")
public class ProvinceSchool extends School{
    
    @Column(name = "province_name",columnDefinition = "varchar(255)")
    private String provinceName;
    
}
