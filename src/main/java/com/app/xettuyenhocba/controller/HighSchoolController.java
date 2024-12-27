package com.app.xettuyenhocba.controller;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.entity.HighSchool;
import com.app.xettuyenhocba.entity.Province;
import com.app.xettuyenhocba.service.IHighSchoolService;
import com.app.xettuyenhocba.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/highschool")
public class HighSchoolController {

    @Autowired
    private IHighSchoolService highSchoolService;

    @GetMapping("/getallhighschool")
    public ResponseEntity<ApiResponse<List<HighSchool>>> getAllProvinces() {
        ApiResponse<List<HighSchool>> result = highSchoolService.getAllHighSchool();
        return ResponseEntity.ok().body(result);
    }
}
