package com.app.xettuyenhocba.service.Impl;

import com.app.xettuyenhocba.repository.NationalRepository;
import com.app.xettuyenhocba.service.INationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NationalServiceImpl implements INationalService {

    @Autowired
    NationalRepository nationalRepository;

    public ResponseEntity<Object> getNationalId(Long national_id) {
        return  ResponseEntity.ok(nationalRepository.findNationalById(national_id));
    }


}
