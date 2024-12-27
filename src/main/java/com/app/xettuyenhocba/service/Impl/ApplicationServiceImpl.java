package com.app.xettuyenhocba.service.Impl;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.ApplicationDTO;
import com.app.xettuyenhocba.repository.ApplicationScoreRepository;
import com.app.xettuyenhocba.service.IApplicationService;
import com.app.xettuyenhocba.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    ApplicationScoreRepository applicationScoreRepository;

    @Override
    public ApiResponse<ApplicationDTO> insertApplicationCore(ApplicationDTO applicationDTO) {
        applicationScoreRepository.insertApplicationScore(applicationDTO.getApplication_id(),applicationDTO.getSubject_id()
                , applicationDTO.getGrade_id(), applicationDTO.getSemester_id(), applicationDTO.getScore());
        return new ApiResponse<>(true, ConstantMessage.USER_INSERT_SUCCESS, applicationDTO);
    }
}
