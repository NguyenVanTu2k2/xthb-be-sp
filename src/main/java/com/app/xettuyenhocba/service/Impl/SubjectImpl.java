package com.app.xettuyenhocba.service.Impl;

import com.app.xettuyenhocba.repository.SubjectRepository;
import com.app.xettuyenhocba.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubjectImpl implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public ResponseEntity<Object> getAllSubject() {
        return ResponseEntity.ok(subjectRepository.findAllSubjects());
    }
}
