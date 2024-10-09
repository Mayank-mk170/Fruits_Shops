package com.api.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpService {
    private final SecureRandom random = new SecureRandom();
    public String generateOtp(){
        return String.format("%06d", random.nextInt(1000000));
    }
}
