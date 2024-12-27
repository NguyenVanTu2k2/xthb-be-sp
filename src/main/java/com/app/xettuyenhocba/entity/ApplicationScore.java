package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ApplicationScore  extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long application_score_id;
    private Long application_id;
    private Long subject_id;
    private Long grade_id;
    private Long semester_id;
    private Float score;
}
