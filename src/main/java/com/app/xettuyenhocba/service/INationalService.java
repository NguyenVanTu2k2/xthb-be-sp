package com.app.xettuyenhocba.service;

import org.springframework.http.ResponseEntity;

public interface INationalService {

    public ResponseEntity<Object> getNationalId(Long national_id);
}
