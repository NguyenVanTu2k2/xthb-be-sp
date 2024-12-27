package com.app.xettuyenhocba.repository;

import com.app.xettuyenhocba.entity.AccountSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSessionRepository extends JpaRepository<AccountSession,Long> {

}
