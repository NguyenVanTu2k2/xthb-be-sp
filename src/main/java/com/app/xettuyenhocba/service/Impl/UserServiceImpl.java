package com.app.xettuyenhocba.service.Impl;

import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.UserDTO;
import com.app.xettuyenhocba.entity.National;
import com.app.xettuyenhocba.entity.User;
import com.app.xettuyenhocba.repository.NationalRepository;
import com.app.xettuyenhocba.repository.UserRepository;
import com.app.xettuyenhocba.service.IUserService;
import com.app.xettuyenhocba.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NationalRepository nationalRepository;

    @Transactional
    @Override
    public ApiResponse<UserDTO> insertUser(UserDTO userDTO) {
            nationalRepository.insertNational(userDTO.getCitizen_id(),userDTO.getNational_image_front(),userDTO.getNational_image_back());
            Long national_id = nationalRepository.findNationalByCitizenId(Long.valueOf(userDTO.getCitizen_id()));
           userRepository.insertUser(userDTO.getAccount_id(),national_id,userDTO.getFull_name(),userDTO.getPhone_number(),userDTO.getEmail(),userDTO.getAddress(),userDTO.getBirth_place(),userDTO.getGender_id(),userDTO.getEthnic(),userDTO.getNationality(),userDTO.getResidence(),userDTO.getGraduation_year(),userDTO.getPriority_area(),userDTO.getPriority_object(),userDTO.getCurrent_address(),userDTO.getReligion(),userDTO.getDate_of_birth(),userDTO.getHigh_school1_id(),userDTO.getHigh_school2_id(),userDTO.getHigh_school3_id());

           return new ApiResponse<>(true, ConstantMessage.USER_INSERT_SUCCESS, userDTO);
    }

//
    @Override
    public  ApiResponse<List<User>> getAllUser() {
       List<User> allUsers =  userRepository.findAllUsers();
        return new ApiResponse<List<User>>(true, ConstantMessage.USER_UPDATE_SUCCESS,allUsers);
    }

    @Transactional
    @Override
    public ApiResponse<UserDTO> getUserByAccountId(Long account_id) {
        User user = userRepository.findUserByAccountId(account_id);
       National national = nationalRepository.findNationalById(userRepository.findNationalByAccountId(account_id));
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount_id(user.getAccount_id());
        userDTO.setFull_name(user.getFull_name());
        userDTO.setNational_id(user.getNational_id());
        userDTO.setPhone_number(user.getPhone_number());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setBirth_place(user.getBirth_place());
        userDTO.setGender_id(user.getGender_id());
        userDTO.setResidence(user.getResidence());
        userDTO.setGraduation_year(user.getGraduation_year());
        userDTO.setPriority_area(user.getPriority_area());
        userDTO.setPriority_object(user.getPriority_object());
        userDTO.setCurrent_address(user.getCurrent_address());
        userDTO.setReligion(user.getReligion());
        userDTO.setDate_of_birth(user.getDate_of_birth());
        userDTO.setHigh_school1_id(user.getHight_school1_id());
        userDTO.setHigh_school2_id(user.getHight_school2_id());
        userDTO.setHigh_school3_id(user.getHight_school3_id());

        return new ApiResponse<UserDTO>(true, ConstantMessage.USER_SELECT_SUCCESS,userDTO);
    }
}

