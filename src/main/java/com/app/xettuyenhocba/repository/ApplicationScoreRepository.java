package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.ApplicationScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ApplicationScoreRepository extends JpaRepository<ApplicationScore, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO application_score (application_id, subject_id, grade_id, semester_id, score, is_delete) VALUES (?1, ?2, ?3, ?4, ?5, 1)", nativeQuery = true)
    int insertApplicationScore(Long applicationId, Long subjectId, Long gradeId, Long semesterId, Float score);

    @Query(value = "SELECT * FROM application_score WHERE application_score_id = ?1", nativeQuery = true)
    ApplicationScore findApplicationScoreById(Long applicationScoreId);

    @Query(value = "SELECT * FROM application_score", nativeQuery = true)
    List<ApplicationScore> findAllApplicationScores();
}
