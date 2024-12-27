package com.app.xettuyenhocba.service;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.entity.HighSchool;

import java.util.List;

public interface IHighSchoolService {
    ApiResponse<List<HighSchool>> getAllHighSchool();
}
