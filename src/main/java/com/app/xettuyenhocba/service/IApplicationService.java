package com.app.xettuyenhocba.service;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.ApplicationDTO;

public interface IApplicationService {
    ApiResponse<ApplicationDTO> insertApplicationCore(ApplicationDTO applicationDTO);
}
