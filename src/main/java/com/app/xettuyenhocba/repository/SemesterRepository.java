package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO semester (semester_name, grade_id, is_delete) VALUES (?1, ?2, ?3)", nativeQuery = true)
    int insertSemester(String semesterName, Long gradeId, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE semester SET semester_name = ?2, grade_id = ?3, is_delete = ?4 WHERE semester_id = ?1", nativeQuery = true)
    int updateSemester(Long semesterId, String semesterName, Long gradeId, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM semester WHERE semester_id = ?1", nativeQuery = true)
    int deleteSemester(Long semesterId);

    @Query(value = "SELECT * FROM semester WHERE semester_id = ?1", nativeQuery = true)
    Semester findSemesterById(Long semesterId);

    @Query(value = "SELECT * FROM semester", nativeQuery = true)
    List<Semester> findAllSemesters();
}
