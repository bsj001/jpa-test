package com.example.jpatest.student.domain.service;

import com.example.jpatest.student.domain.model.SsDto;
import com.example.jpatest.student.domain.model.SsDto2;
import com.example.jpatest.student.domain.model.Student;
import com.example.jpatest.student.domain.model.StudentAndSchoolInfo;
import com.example.jpatest.student.repository.JpaStudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentDomainService {

    private JpaStudentRepository jpaStudentRepository;

    private EntityManager entityManager;


    @Autowired
    public void setJpaStudentRepository(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Student> query() {
        return jpaStudentRepository.findAll();
    }

    //使用new 
    public List<SsDto> listStudentAndSchool() {
        return jpaStudentRepository.listStudentAndSchool();
    }

    //使用 EntityManager ,可以随意组装
    public List<SsDto2> listStudentAndSchool2() {
        String sql = "select sc.school_name,s.name from student s left join school sc on s.school_id = sc.id where s.id = :id";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.setParameter("id", 1);
        return nativeQuery.getResultList();
    }

    public List<Map> listStudentAndSchool3() {
        return jpaStudentRepository.listStudentAndSchool3();
    }

    public Page<StudentAndSchoolInfo> listStudentAndSchool4(List<Integer> ids, String name) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest page = PageRequest.of(0, 1, sort);
        return jpaStudentRepository.listStudentAndSchool4(ids, name, page);
    }
}
