package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class CombinationScore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long combination_score_id;
    private Long combination_id;
    private Long university_admission_id;
    private Float pass_score;
}
