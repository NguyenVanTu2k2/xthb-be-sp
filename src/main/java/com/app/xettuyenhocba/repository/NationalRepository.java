package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NationalRepository extends JpaRepository<National, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO national ( citizen_id, national_image_front, national_image_back, is_delete) VALUES (?1, ?2, ?3,1)", nativeQuery = true)
    int insertNational(Integer citizenId, String nationalImageFront, String nationalImageBack);

    @Query(value = "SELECT * FROM national WHERE national_id = ?1", nativeQuery = true)
    National findNationalById(Long nationalId);

    @Query(value = "SELECT * FROM national", nativeQuery = true)
    List<National> findAllNationals();

    @Query(value = "SELECT national_id FROM national WHERE citizen_id = ?1", nativeQuery = true)
    Long findNationalByCitizenId(Long citizen_id);
}
