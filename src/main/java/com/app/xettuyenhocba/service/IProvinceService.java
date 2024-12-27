package com.app.xettuyenhocba.service;
import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.entity.Province;;

import java.util.List;

public interface IProvinceService {
    public ApiResponse<List<Province>> getAllProvinces();
}
