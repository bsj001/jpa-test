package com.example.jpatest.student.repository;


import com.example.jpatest.student.domain.model.SsDto;
import com.example.jpatest.student.domain.model.SsDto2;
import com.example.jpatest.student.domain.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface JpaStudentRepository extends JpaRepository<Student, Integer> {
    
    
    @Query("select new com.example.jpatest.student.domain.model.SsDto(sc,s) from Student s left join School sc on s.school_id = sc.id")
    List<SsDto> listStudentAndSchool();

    @Query("select sc.school_name as schoolName,s.name as name from Student s left join School sc on s.school_id = sc.id")
    List<Map> listStudentAndSchool3();
}
