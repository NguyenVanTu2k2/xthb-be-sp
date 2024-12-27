package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private Long account_id;
    private String full_name;
    private String national_id;
    private String phone_number;
    private String email;
    private String address;
    private String birth_place;
    private Long gender_id;

    @Column(name = "ethnic")
    private String ethnic;
    private String nationality;
    private String residence;
    private String graduation_year;
    private Long priority_area;
    private Long priority_object;
    private String current_address;
    private String religion;
    private Date date_of_birth;
    private Long hight_school1_id;
    private Long hight_school2_id;
    private Long hight_school3_id;
}

