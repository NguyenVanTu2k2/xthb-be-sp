package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user ( account_id,national_id,full_name,  phone_number, email, address, birth_place, gender_id, ethnic, nationality, residence, graduation_year, priority_area, priority_object, current_address, religion, date_of_birth,hight_school1_id,hight_school2_id,hight_school3_id,is_delete) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16,?17,?18,?19,?20, 1)", nativeQuery = true)
    int insertUser(Long account_id,Long national_id, String full_name,  String phone_number, String email, String address, String birth_place, Long gender_id, String ethnic, String nationality, String residence, String graduation_year, Long priority_area, Long priority_object, String current_address, String religion, Date date_of_birth,Long  high_school1_id,Long  high_school2_id,Long  high_school3_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user ( account_id,full_name, national_id, phone_number, email, address, birth_place, gender_id, ethnic, nationality, residence, graduation_year, priority_area, priority_object, current_address, religion, date_of_birth,is_delete) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16,?17, 0)", nativeQuery = true)
    int updatetUser(Long account_id, String full_name, String national_id, String phone_number, String email, String address, String birth_place, Long gender_id, String ethnic, String nationality, String residence, String graduation_year, Long priority_area, Long priority_object, String current_address, String religion, Date date_of_birth);

    @Query(value = "SELECT * FROM user WHERE account_id = ?1 AND is_delete = 1", nativeQuery = true)
    User findUserByAccountId(Long account_id);

    @Query(value = "SELECT national_id FROM user WHERE account_id = ?1 AND is_delete = 1", nativeQuery = true)
    Long findNationalByAccountId(Long account_id);

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> findAllUsers();
}
