package com.finguard.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionResponse {

    private String transactionId;
    private String customerId;
    private String merchantId;
    private BigDecimal amount;
    private String currency;
    private String channel;
    private String deviceId;
    private String location;
    private String status;
    private LocalDateTime createdAt;

    private Integer riskScore;
    private String riskLevel;
    private String decision;
    private List<String> riskFlags;

    public TransactionResponse() {
    }

    public TransactionResponse(
            String transactionId,
            String customerId,
            String merchantId,
            BigDecimal amount,
            String currency,
            String channel,
            String deviceId,
            String location,
            String status,
            LocalDateTime createdAt,
            Integer riskScore,
            String riskLevel,
            String decision,
            List<String> riskFlags) {

        this.transactionId = transactionId;
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.channel = channel;
        this.deviceId = deviceId;
        this.location = location;
        this.status = status;
        this.createdAt = createdAt;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.decision = decision;
        this.riskFlags = riskFlags;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getChannel() {
        return channel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public String getDecision() {
        return decision;
    }

    public List<String> getRiskFlags() {
        return riskFlags;
    }
}