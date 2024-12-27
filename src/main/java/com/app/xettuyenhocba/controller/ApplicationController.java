package com.app.xettuyenhocba.controller;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.ApplicationDTO;
import com.app.xettuyenhocba.dto.UserDTO;
import com.app.xettuyenhocba.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
@CrossOrigin
public class ApplicationController {
    @Autowired
    IApplicationService iApplicationService;

    @PostMapping("/insertapplicationcores")
    public ResponseEntity<ApiResponse<ApplicationDTO>> insertApplicationCores(@RequestBody ApplicationDTO applicationDTO) {
        ApiResponse<ApplicationDTO> result = iApplicationService.insertApplicationCore(applicationDTO);
        return ResponseEntity.ok().body(result);
    }
}
