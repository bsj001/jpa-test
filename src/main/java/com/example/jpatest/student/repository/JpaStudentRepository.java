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
    
    //repository自定义查询
    //@Query(value = "SELECT cr.project_number as projectNumber,cr.file_number as fileNumber,cr.role_id as projectRoleId," +
    //        "r.project_role as projectRole,r.responsibility_text as responsibilityText," +
    //        "GROUP_CONCAT(cr.contacts_id) as contactsId,GROUP_CONCAT(c.user_full_name)as userFullName " +
    //        "FROM project_role_contacts_relation cr left JOIN contacts_info c on cr.contacts_id=c.id " +
    //        "LEFT JOIN project_role r on cr.role_id=r.id WHERE cr.project_number=?1 AND cr.file_number=?2 " +
    //        "GROUP BY cr.role_id",nativeQuery = true)
    //List<Object[]> roleAndDutyVoList(String projectNumber, String fileNumber);
    
    //2,接收类
    //@Data
    //@AllArgsConstructor  //（有参构造）
    //@NoArgsConstructor   //（无参构造）
    //public class RoleAndDutyVo {
    //
    //    private String projectNumber;
    //    private String fileNumber;
    //    private String projectRoleId;
    //    private String projectRole;
    //    private String responsibilityText;
    //    private String contactsId;
    //    private String userFullName;
    //
    //}
    
    //3.把List<Object[]>转化成List<RoleAndDutyVo>
    
    //4,实际业务实现
    //public List<RoleAndDutyVo> roleContactsList(String projectNumber, String fileNumber) {
    //    List<Object[]> objects = projectRoleContactsRepository.roleAndDutyVoList(projectNumber, fileNumber);
    //    List<RoleAndDutyVo> vos = EntityUtils.castEntity(objects, RoleAndDutyVo.class, new RoleAndDutyVo());
    //
    //}
}
