package com.app.xettuyenhocba.service;


import com.app.xettuyenhocba.dto.AccountDTO;
import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.AuthDTO;

public interface IAuthenService {

   ApiResponse<AuthDTO> registerUser(AuthDTO authDTO) ;
   ApiResponse<AuthDTO> verifyOTP(AuthDTO authDTO) ;

   ApiResponse<AuthDTO> changePassword(AuthDTO authDTO) ;
   ApiResponse<AuthDTO> login(AuthDTO authDTO);

}
