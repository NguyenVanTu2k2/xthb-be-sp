package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Combination extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long combination_id;
    private String combination_name;
    private Long major_id;
    private Long subject1_id;
    private Long subject2_id;
    private Long subject3_id;
}
