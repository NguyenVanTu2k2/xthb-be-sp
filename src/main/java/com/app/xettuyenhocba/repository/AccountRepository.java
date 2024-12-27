package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.Account;
import com.app.xettuyenhocba.entity.AccountSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account WHERE email = ?1 ", nativeQuery = true)
    Account findByEmail(String email);

    @Query(value = "SELECT * FROM Account WHERE user_name = ?1", nativeQuery = true)
    Account findByUserName(String userName);

    @Query(value = "SELECT * FROM Account  WHERE email = ?1 AND account_verify = ?2" , nativeQuery = true)
    Account findByEmailAndAccountVerify(String email, int verify);
    @Query(value = "SELECT * FROM Account WHERE user_name = ?1 AND account_verify = ?2 ", nativeQuery = true)
    Account findByUserNameAndAccountVerify(String userName, int verify);

    @Modifying
    @Transactional
    @Query(value ="UPDATE Account  SET password = ?3, user_name = ?2 WHERE email = ?1 AND account_verify = ?4" ,nativeQuery = true)
    int updateUserNameAndPasswordByEmailVerify(String email, String userName, String password, int verify);

    @Modifying
    @Transactional
    @Query(value ="UPDATE Account SET account_verify = ?3 WHERE email = ?1 AND user_name = ?2",nativeQuery = true)
    int updateAccountVerifyByEmail(String email, String userName, int verify);


    @Query(value ="SELECT * FROM Account  WHERE email = ?1 AND password = ?2 AND account_verify = ?3 and account_role = ?4",nativeQuery = true)
    Account findByEmailAndPassword(String email, String password, int verify, int role );

    @Modifying
    @Transactional
    @Query(value ="UPDATE Account a SET a.password = ?2 WHERE a.email = ?1")
    int updatePasswordByEmail(String email, String newPassword);

    @Query(value ="SELECT * FROM account_session  WHERE session_id = ?1 ",nativeQuery = true)
    AccountSession findByAccountSessionId(long sessionId);

}