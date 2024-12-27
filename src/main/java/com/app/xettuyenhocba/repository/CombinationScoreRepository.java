package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.CombinationScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CombinationScoreRepository extends JpaRepository<CombinationScore, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO combination_score (combination_id, university_admission_id, pass_score, is_delete) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    int insertCombinationScore(Long combinationId, Long universityAdmissionId, Float passScore, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE combination_score SET combination_id = ?2, university_admission_id = ?3, pass_score = ?4, is_delete = ?5 WHERE combination_score_id = ?1", nativeQuery = true)
    int updateCombinationScore(Long combinationScoreId, Long combinationId, Long universityAdmissionId, Float passScore, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM combination_score WHERE combination_score_id = ?1", nativeQuery = true)
    int deleteCombinationScore(Long combinationScoreId);

    @Query(value = "SELECT * FROM combination_score WHERE combination_score_id = ?1", nativeQuery = true)
    CombinationScore findCombinationScoreById(Long combinationScoreId);

    @Query(value = "SELECT * FROM combination_score", nativeQuery = true)
    List<CombinationScore> findAllCombinationScores();
}
