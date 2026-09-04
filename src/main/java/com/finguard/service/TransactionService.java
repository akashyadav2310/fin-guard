package com.finguard.service;

import com.finguard.dto.TransactionRequest;
import com.finguard.dto.TransactionResponse;

public interface TransactionService {

    TransactionResponse createTransaction(TransactionRequest request);

    TransactionResponse getTransaction(String transactionId);
}