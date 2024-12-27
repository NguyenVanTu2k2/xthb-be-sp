package com.app.xettuyenhocba.controller;

import com.app.xettuyenhocba.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;

    @GetMapping("/getallsubject")
    public ResponseEntity<Object> getAllSubject() {
        return subjectService.getAllSubject();
    }
}
