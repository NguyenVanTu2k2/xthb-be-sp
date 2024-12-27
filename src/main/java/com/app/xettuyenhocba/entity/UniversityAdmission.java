package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UniversityAdmission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long university_admission_id;
    private String university_admission_name;
    private Date university_admission_time;
}
