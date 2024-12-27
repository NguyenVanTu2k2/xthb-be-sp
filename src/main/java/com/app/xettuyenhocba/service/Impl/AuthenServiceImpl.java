package com.app.xettuyenhocba.service.Impl;


import com.app.xettuyenhocba.dto.ApiResponse;
import com.app.xettuyenhocba.dto.AuthDTO;
import com.app.xettuyenhocba.entity.Account;
import com.app.xettuyenhocba.repository.AccountRepository;
import com.app.xettuyenhocba.service.IAuthenService;
import com.app.xettuyenhocba.service.IEmailService;
import com.app.xettuyenhocba.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Random;

@Service
public class AuthenServiceImpl implements IAuthenService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private IEmailService iEmailService;
    private static final int OTP_LENGTH = 6;

    @Override
    public ApiResponse<AuthDTO> registerUser(AuthDTO authDTO) {
        Account existingAccount = accountRepository.findByEmailAndAccountVerify(authDTO.getEmail(), 1);
        if (existingAccount != null) {
            return new ApiResponse<>(false, ConstantMessage.AUTH_ACCOUNT_GMAIL_EXITS, authDTO);
        }
        Account existingUserName = accountRepository.findByUserNameAndAccountVerify(authDTO.getUserName(), 1);
        if (existingUserName != null) {
            return new ApiResponse<>(false, ConstantMessage.AUTH_ACCOUNT_USERNAME_EXITS, authDTO);
        }
        Account account = new Account();
        account.setEmail(authDTO.getEmail());
        account.setPassword(authDTO.getPassword());
        account.setAccountRole(1);
        account.setUserName(authDTO.getUserName());

        String otp = generateOTP();
        account.setAccountOtp(otp);
        account.setAccountVerify(0);
        Date currentDate = new Date(System.currentTimeMillis());
        account.setAccountRegistrationTime(currentDate);
        account.setIsDelete(0);
        Account existingUserNameNotVeryfy = accountRepository.findByEmailAndAccountVerify(authDTO.getEmail(), 0);

        if(existingUserNameNotVeryfy != null){
            account.setUpdatedAt(currentDate);
            accountRepository.updateUserNameAndPasswordByEmailVerify(authDTO.getEmail(), authDTO.getUserName(), authDTO.getPassword(), 0);

        }else {
            accountRepository.save(account);
        }

        iEmailService.sendOtpEmail(authDTO.getEmail(), "Xác thực tài khoản", "Mã OTP của bạn là : " + otp);

        return new ApiResponse<>(true, ConstantMessage.AUTH_ACCOUNT_VERIFY, authDTO);
    }


    private String generateOTP() {
        StringBuilder otp = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
    @Override
    public ApiResponse<AuthDTO> verifyOTP(AuthDTO authDTO) {
        Account existingAccount = accountRepository.findByEmailAndAccountVerify(authDTO.getEmail(),0);
        if(existingAccount != null){
            if (authDTO.getOtp().equals(existingAccount.getAccountOtp())){
               int count = accountRepository.updateAccountVerifyByEmail(authDTO.getEmail(), authDTO.getUserName(), 1);
               if (count > 0){
                   return new ApiResponse<>(true, ConstantMessage.AUTH_ACCOUNT_SUCCESS, authDTO);
               }
            }
        }
        return new ApiResponse<>(false, ConstantMessage.AUTH_ACCOUNT_FAILD, authDTO);
    }


    @Override
    @Transactional
    public ApiResponse<AuthDTO> changePassword(AuthDTO authDTO) {
        int updatedCount = accountRepository.updatePasswordByEmail(authDTO.getEmail(), authDTO.getPassword());
        if (updatedCount == 0) {
            return new ApiResponse<>(false, ConstantMessage.AUTH_ACCOUNT_CHANGE_PW_FAILD, authDTO);
        }
        return new ApiResponse<>(false, ConstantMessage.AUTH_ACCOUNT_CHANGE_PW_SUCCESS, authDTO);
    }
    @Override
    public ApiResponse<AuthDTO> login(AuthDTO authDTO) {
         Account account = accountRepository.findByEmailAndPassword(authDTO.getEmail(), authDTO.getPassword(), 1, 1);

         if (account != null){
             authDTO.setAccount_id(account.getAccount_id());
             return new ApiResponse<>(true, ConstantMessage.AUTH_ACCOUNT_LOGIN_SUCCESS, authDTO);

        }
        return new ApiResponse<>(false, ConstantMessage.AUTH_ACCOUNT_LOGIN_FAILD, authDTO);
    }

}
