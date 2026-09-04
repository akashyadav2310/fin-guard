package com.finguard.dto;

import java.time.LocalDateTime;

public class CustomerResponse {

    private String customerId;
    private String name;
    private String email;
    private String mobile;
    private String status;
    private LocalDateTime createdAt;

    public CustomerResponse() {
    }

    public CustomerResponse(String customerId, String name, String email,
                            String mobile, String status,
                            LocalDateTime createdAt) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}