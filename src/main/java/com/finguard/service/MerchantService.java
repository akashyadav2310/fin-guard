package com.finguard.service;

import com.finguard.dto.MerchantRequest;
import com.finguard.dto.MerchantResponse;

public interface MerchantService {

    MerchantResponse createMerchant(MerchantRequest request);

    MerchantResponse getMerchant(String merchantId);
}