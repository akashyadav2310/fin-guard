package com.finguard.service;

import com.finguard.dto.CustomerRequest;
import com.finguard.dto.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest request);

    CustomerResponse getCustomer(String customerId);
}