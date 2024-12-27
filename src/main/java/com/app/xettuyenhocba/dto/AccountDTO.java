package com.app.xettuyenhocba.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private String email;
    private String message;
    private int state;
    private Long account_id;
}
