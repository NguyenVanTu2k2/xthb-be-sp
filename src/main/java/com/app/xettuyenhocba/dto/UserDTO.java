package com.app.xettuyenhocba.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserDTO  {
    private Long account_id;
    private String full_name;
    private String national_id;
    private String phone_number;
    private String email;
    private String address;
    private String birth_place;
    private Long gender_id;
    private String ethnic;
    private String nationality;
    private String residence;
    private String graduation_year;
    private Long priority_area;
    private Long priority_object;
    private String current_address;
    private String religion;
    private Date date_of_birth;
    private Integer citizen_id;
    private String national_image_front;
    private String national_image_back;
    private Long is_delete;
    private Long high_school1_id;
    private Long high_school2_id;
    private Long high_school3_id;

}
