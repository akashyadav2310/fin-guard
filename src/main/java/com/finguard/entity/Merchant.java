package com.finguard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Merchant {

    @Id
    private String merchantId;
    private String merchantName;
    private String merchantType;
    private String status;
    private LocalDateTime createdAt;

    public Merchant() {
    }

    public Merchant(String merchantId,
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

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}