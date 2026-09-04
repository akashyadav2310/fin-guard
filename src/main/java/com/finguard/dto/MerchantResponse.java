package com.finguard.dto;

import java.time.LocalDateTime;

public class MerchantResponse {

    private String merchantId;
    private String merchantName;
    private String merchantType;
    private String status;
    private LocalDateTime createdAt;

    public MerchantResponse() {
    }

    public MerchantResponse(String merchantId,
                            String merchantName,
                            String merchantType,
                            String status,
                            LocalDateTime createdAt) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.merchantType = merchantType;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}