package com.app.xettuyenhocba.controller;

import com.app.xettuyenhocba.dto.AccountDTO;
import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.AuthDTO;
import com.app.xettuyenhocba.service.IAuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authen")
@CrossOrigin
public class AuthenController {
    @Autowired
    private IAuthenService iAuthenService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<AuthDTO>> SignInUser(@RequestBody AuthDTO authDTO) {
        ApiResponse<AuthDTO> result = iAuthenService.registerUser(authDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/verifyotp")
    public ResponseEntity<ApiResponse<AuthDTO>> VerifyOTP(@RequestBody AuthDTO authDTO) {
        ApiResponse<AuthDTO> result = iAuthenService.verifyOTP(authDTO);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthDTO>> Login(@RequestBody AuthDTO authDTO) {
        ApiResponse<AuthDTO> result = iAuthenService.login(authDTO);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/changepassword")
    public ResponseEntity<ApiResponse<AuthDTO>> ChangePassword(@RequestBody AuthDTO authDTO) {
        ApiResponse<AuthDTO> result = iAuthenService.changePassword(authDTO);
        return ResponseEntity.ok().body(result);
    }

}
