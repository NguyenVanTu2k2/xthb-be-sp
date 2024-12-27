package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO application (user_id, university_admission_id, combination_id, is_delete) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    int insertApplication(Long userId, Long universityAdmissionId, Long combinationId, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "UPDATE application SET user_id = ?2, university_admission_id = ?3, combination_id = ?4, is_delete = ?5 WHERE application_id = ?1", nativeQuery = true)
    int updateApplication(Long applicationId, Long userId, Long universityAdmissionId, Long combinationId, Integer isDelete);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM application WHERE application_id = ?1", nativeQuery = true)
    int deleteApplication(Long applicationId);

    @Query(value = "SELECT * FROM application WHERE application_id = ?1", nativeQuery = true)
    Application findApplicationById(Long applicationId);

    @Query(value = "SELECT * FROM application", nativeQuery = true)
    List<Application> findAllApplications();
}
