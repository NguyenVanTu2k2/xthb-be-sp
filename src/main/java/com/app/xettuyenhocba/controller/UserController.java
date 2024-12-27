package com.app.xettuyenhocba.controller;
import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.UserDTO;
import com.app.xettuyenhocba.entity.User;
import com.app.xettuyenhocba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
 @Autowired
 IUserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        String test = "test ok";
        System.out.println("test");
        return ResponseEntity.ok().body(test);
    }
    @PostMapping("/post/test")
    public ResponseEntity<UserDTO> test(@RequestBody UserDTO userDTO) {
        System.out.println("user post test");
        return ResponseEntity.ok().body(userDTO);
    }
    @PostMapping("/insertuser")
    public ResponseEntity<ApiResponse<UserDTO>> insertUser(@RequestBody UserDTO userDTO) {
        ApiResponse<UserDTO> result = userService.insertUser(userDTO);
        return ResponseEntity.ok().body(result);
    }

//    @PostMapping("/updatetuser")
//    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@RequestBody UserDTO userDTO) {
//        ApiResponse<UserDTO> result = userService.updateUser(userDTO);
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/getalluser")
    public  ApiResponse<List<User>> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getuser/{account_id}")
    public ApiResponse<UserDTO> getUserByAccountId(@PathVariable Long account_id) {
        return userService.getUserByAccountId(account_id);
    }
}
