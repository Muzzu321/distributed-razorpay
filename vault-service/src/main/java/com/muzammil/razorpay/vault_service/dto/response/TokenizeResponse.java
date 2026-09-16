package com.muzammil.razorpay.vault_service.dto.response;


import com.muzammil.razorpay.common_lib.enums.CardBrand;

public record TokenizeResponse(
        String token,
        String lastFour,
        CardBrand brand,
        Integer expiryMonth,
        Integer expiryYear
) {
}
