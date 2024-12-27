package com.app.xettuyenhocba.service.Impl;
import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.entity.Province;
import com.app.xettuyenhocba.repository.ProvinceRepository;
import com.app.xettuyenhocba.service.IProvinceService;
import com.app.xettuyenhocba.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public ApiResponse<List<Province>> getAllProvinces() {
        List<Province> provinces = provinceRepository.findAll();
        return new ApiResponse<List<Province>>(true, ConstantMessage.USER_SELECT_SUCCESS,provinces);
    }
}
