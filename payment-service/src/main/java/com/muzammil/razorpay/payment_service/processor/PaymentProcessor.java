package com.muzammil.razorpay.payment_service.processor;


import com.muzammil.razorpay.common_lib.dto.PaymentProcessorRequest;
import com.muzammil.razorpay.common_lib.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);

}
