package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO subject (subject_name, is_delete) VALUES (?1, ?2)", nativeQuery = true)
    int insertSubject(String subjectName, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE subject SET subject_name = ?2, is_delete = ?3 WHERE subject_id = ?1", nativeQuery = true)
    int updateSubject(Long subjectId, String subjectName, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM subject WHERE subject_id = ?1", nativeQuery = true)
    int deleteSubject(Long subjectId);

    @Query(value = "SELECT * FROM subject WHERE subject_id = ?1", nativeQuery = true)
    Subject findSubjectById(Long subjectId);

    @Query(value = "SELECT * FROM subject", nativeQuery = true)
    List<Subject> findAllSubjects();

}
