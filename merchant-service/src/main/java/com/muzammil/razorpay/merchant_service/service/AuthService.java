package com.muzammil.razorpay.merchant_service.service;


import com.muzammil.razorpay.merchant_service.dto.request.LoginRequest;
import com.muzammil.razorpay.merchant_service.dto.request.MerchantSignupRequest;
import com.muzammil.razorpay.merchant_service.dto.response.LoginResponse;
import com.muzammil.razorpay.merchant_service.dto.response.MerchantResponse;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);

    LoginResponse login(LoginRequest request);
}
