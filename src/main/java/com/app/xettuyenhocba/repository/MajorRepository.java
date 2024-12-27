package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Major;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MajorRepository {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO major (major_name, is_delete, image1, image2, image3, title, description) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    int insertMajor(String majorName, Integer isDelete, String image1, String image2, String image3, String title, String description);

    @Modifying
    @Transactional
    @Query(value = "UPDATE major SET major_name = ?2, is_delete = ?3, image1 = ?4, image2 = ?5, image3 = ?6, title = ?7, description = ?8 WHERE major_id = ?1", nativeQuery = true)
    int updateMajor(Long majorId, String majorName, Integer isDelete, String image1, String image2, String image3, String title, String description);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM major WHERE major_id = ?1", nativeQuery = true)
    int deleteMajor(Long majorId);

    @Query(value = "SELECT * FROM major WHERE major_id = ?1", nativeQuery = true)
    Major findMajorById(Long majorId);

    @Query(value = "SELECT * FROM major", nativeQuery = true)
    List<Major> findAllMajors();
}
