package com.finguard.service;

import com.finguard.dto.TransactionRequest;
import com.finguard.dto.TransactionResponse;
import com.finguard.entity.Transaction;
import com.finguard.exception.CustomerNotFoundException;
import com.finguard.exception.MerchantNotFoundException;
import com.finguard.exception.TransactionNotFoundException;
import com.finguard.repository.CustomerRepository;
import com.finguard.repository.MerchantRepository;
import com.finguard.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import com.finguard.risk.RiskAssessmentService;
import com.finguard.risk.RiskResult;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;
    private final MerchantRepository merchantRepository;
    private final RiskAssessmentService riskAssessmentService;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            CustomerRepository customerRepository,
            MerchantRepository merchantRepository,
            RiskAssessmentService riskAssessmentService) {

        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
        this.merchantRepository = merchantRepository;
        this.riskAssessmentService = riskAssessmentService;
    }

    @Override
    public TransactionResponse createTransaction(
            TransactionRequest request) {

        customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found: "
                                        + request.getCustomerId()));

        merchantRepository.findById(request.getMerchantId())
                .orElseThrow(() ->
                        new MerchantNotFoundException(
                                "Merchant not found: "
                                        + request.getMerchantId()));

        String transactionId =
                "TXN-" + UUID.randomUUID();

        Transaction transaction = new Transaction(
                transactionId,
                request.getCustomerId(),
                request.getMerchantId(),
                request.getAmount(),
                request.getCurrency(),
                request.getChannel(),
                request.getDeviceId(),
                request.getLocation(),
                "RECEIVED",
                LocalDateTime.now()
        );

        Transaction savedTransaction =
                transactionRepository.save(transaction);

        RiskResult riskResult =
                riskAssessmentService.assessRisk(savedTransaction);

        return mapToResponse(savedTransaction, riskResult);
    }

    @Override
    public TransactionResponse getTransaction(
            String transactionId) {

        Transaction transaction =
                transactionRepository.findById(transactionId)
                        .orElseThrow(() ->
                                new TransactionNotFoundException(
                                        "Transaction not found: "
                                                + transactionId));

        RiskResult riskResult =
                riskAssessmentService.assessRisk(transaction);

        return mapToResponse(transaction, riskResult);
    }

    private TransactionResponse mapToResponse(
            Transaction transaction,
            RiskResult riskResult) {

        return new TransactionResponse(
                transaction.getTransactionId(),
                transaction.getCustomerId(),
                transaction.getMerchantId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getChannel(),
                transaction.getDeviceId(),
                transaction.getLocation(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                riskResult.getRiskScore(),
                riskResult.getRiskLevel(),
                riskResult.getDecision(),
                riskResult.getFlags()
        );
    }
}