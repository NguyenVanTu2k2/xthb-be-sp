package com.app.xettuyenhocba.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class BaseEntity {

    private Integer isDelete;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}
