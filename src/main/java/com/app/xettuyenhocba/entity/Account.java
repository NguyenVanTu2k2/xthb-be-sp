package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Account extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    private String userName;


    private String password;


    private String email;


    private Integer accountRole;


    private Integer accountVerify;


    private String accountOtp;


    private Date accountRegistrationTime;


}
