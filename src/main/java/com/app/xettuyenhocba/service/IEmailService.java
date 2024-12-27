package com.app.xettuyenhocba.service;

public interface IEmailService {
    public void sendOtpEmail(String toEmail, String subject, String body);
}
