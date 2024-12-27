package com.app.xettuyenhocba.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HighSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long high_school_id;
    private String school_name;
    private String address;
    private Integer province_id;
    private Integer school_id;

}
