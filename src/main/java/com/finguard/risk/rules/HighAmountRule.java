package com.finguard.risk.rules;

import com.finguard.entity.Transaction;
import com.finguard.risk.RiskRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class HighAmountRule implements RiskRule {

    private static final BigDecimal HIGH_AMOUNT =
            new BigDecimal("50000");

    @Override
    public int evaluate(Transaction transaction) {

        if (transaction.getAmount().compareTo(HIGH_AMOUNT) > 0) {
            return 30;
        }

        return 0;
    }

    @Override
    public String getFlag() {
        return "HIGH_TRANSACTION_AMOUNT";
    }
}