package com.app.xettuyenhocba.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {
    private Long account_id;
    private String email;
    private String password;
    private String userName;
    private String otp;
    private Long sessionId;

}
