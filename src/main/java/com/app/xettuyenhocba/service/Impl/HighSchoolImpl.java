package com.app.xettuyenhocba.service.Impl;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.entity.HighSchool;
import com.app.xettuyenhocba.repository.HighSchoolRepository;
import com.app.xettuyenhocba.service.IHighSchoolService;
import com.app.xettuyenhocba.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolImpl implements IHighSchoolService {

    @Autowired
    private HighSchoolRepository highSchoolRepository;

    @Override
    public ApiResponse<List<HighSchool>> getAllHighSchool() {
        List<HighSchool> highSchools = highSchoolRepository.findAll();
        return new ApiResponse<List<HighSchool>>(true, ConstantMessage.USER_SELECT_SUCCESS,highSchools);
    }
}
