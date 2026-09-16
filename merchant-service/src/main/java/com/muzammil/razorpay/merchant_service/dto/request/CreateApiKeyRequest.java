package com.muzammil.razorpay.merchant_service.dto.request;


import com.muzammil.razorpay.common_lib.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
