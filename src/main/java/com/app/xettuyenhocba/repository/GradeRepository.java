package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO grade (grade_name, is_delete) VALUES (?1, ?2)", nativeQuery = true)
    int insertGrade(String gradeName, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE grade SET grade_name = ?2, is_delete = ?3 WHERE grade_id = ?1", nativeQuery = true)
    int updateGrade(Long gradeId, String gradeName, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM grade WHERE grade_id = ?1", nativeQuery = true)
    int deleteGrade(Long gradeId);

    @Query(value = "SELECT * FROM grade WHERE grade_id = ?1", nativeQuery = true)
    Grade findGradeById(Long gradeId);

    @Query(value = "SELECT * FROM grade", nativeQuery = true)
    List<Grade> findAllGrades();
}
