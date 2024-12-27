package com.app.xettuyenhocba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class National extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long national_id;
    private Integer citizen_id;
    private String national_image_front;
    private String national_image_back;
}

