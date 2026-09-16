package com.muzammil.razorpay.merchant_service.mapper;

import com.muzammil.razorpay.merchant_service.dto.response.ApiKeyCreateResponse;
import com.muzammil.razorpay.merchant_service.dto.response.ApiKeyResponse;
import com.muzammil.razorpay.merchant_service.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

    ApiKeyCreateResponse toCreateResponse(ApiKey apiKey);

    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
