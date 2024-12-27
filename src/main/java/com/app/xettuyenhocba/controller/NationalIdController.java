package com.app.xettuyenhocba.controller;

import com.app.xettuyenhocba.service.INationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nationalid")
public class NationalIdController {

    @Autowired
    INationalService nationalIdService;

    @GetMapping("/getnationalid/{national_id}")
    public ResponseEntity<Object> getNationalId(@PathVariable Long national_id) {
        return ResponseEntity.ok().body(nationalIdService.getNationalId(national_id));
    }
}
