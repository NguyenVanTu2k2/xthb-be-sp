package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Combination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface CombinationRepository extends JpaRepository<Combination, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO combination (combination_name, major_id, subject1_id, subject2_id, subject3_id, is_delete) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int insertCombination(String combinationName, Long majorId, Long subject1Id, Long subject2Id, Long subject3Id, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE combination SET combination_name = ?2, major_id = ?3, subject1_id = ?4, subject2_id = ?5, subject3_id = ?6, is_delete = ?7 WHERE combination_id = ?1", nativeQuery = true)
    int updateCombination(Long combinationId, String combinationName, Long majorId, Long subject1Id, Long subject2Id, Long subject3Id, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM combination WHERE combination_id = ?1", nativeQuery = true)
    int deleteCombination(Long combinationId);

    @Query(value = "SELECT * FROM combination WHERE combination_id = ?1", nativeQuery = true)
    Combination findCombinationById(Long combinationId);

    @Query(value = "SELECT * FROM combination", nativeQuery = true)
    List<Combination> findAllCombinations();
}
