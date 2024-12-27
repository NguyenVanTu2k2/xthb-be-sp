package com.app.xettuyenhocba.service;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.UserDTO;
import com.app.xettuyenhocba.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    public ApiResponse<UserDTO> insertUser(UserDTO userDTO);

//    public ApiResponse<UserDTO> updateUser(UserDTO userDTO);



    public  ApiResponse<List<User>> getAllUser();

    public ApiResponse<UserDTO> getUserByAccountId(Long account_id);

}
