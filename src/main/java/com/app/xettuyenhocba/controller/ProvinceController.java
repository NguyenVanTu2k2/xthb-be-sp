package com.app.xettuyenhocba.controller;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.entity.Province;
import com.app.xettuyenhocba.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/getallprovinces")
    public ResponseEntity<ApiResponse<List<Province>>> getAllProvinces() {
        ApiResponse<List<Province>> result = provinceService.getAllProvinces();
        return ResponseEntity.ok().body(result);
    }
}
