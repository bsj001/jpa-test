package com.example.jpatest.student.repository;


import com.example.jpatest.student.domain.model.SsDto;
import com.example.jpatest.student.domain.model.SsDto2;
import com.example.jpatest.student.domain.model.Student;
import com.example.jpatest.student.domain.model.StudentAndSchoolInfo;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface JpaStudentRepository extends JpaRepository<Student, Integer> {
    
    
    @Query("select new com.example.jpatest.student.domain.model.SsDto(sc,s) from Student s left join School sc on s.school_id = sc.id")
    List<SsDto> listStudentAndSchool();

    @Query("select sc.school_name as schoolName,s.name as name from Student s left join School sc on s.school_id = sc.id")
    List<Map> listStudentAndSchool3();

    //@Query("select s.name as name ,sc.school_name as schoolName from Student s left join School sc on s.school_id = sc.id where (:ids is null or s.id in :ids) and (:name is null or s.name = :name)")
    @Query("select s.name as name ,sc.school_name as schoolName from Student s left join School sc on s.school_id = sc.id where (:ids is null or s.id in :ids) and (:name is null or sc.school_name = :name)")
    Page<StudentAndSchoolInfo> listStudentAndSchool4(@Param("ids") List<Integer> ids , @Param("name") String name, @Param("page")Pageable pageable);
}
