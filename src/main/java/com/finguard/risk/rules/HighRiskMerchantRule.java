package com.finguard.risk.rules;

import com.finguard.entity.Transaction;
import com.finguard.risk.RiskRule;
import org.springframework.stereotype.Component;

@Component
public class HighRiskMerchantRule implements RiskRule {

    @Override
    public int evaluate(Transaction transaction) {

        if (transaction.getMerchantId() != null
                && transaction.getMerchantId().startsWith("RISK-")) {

            return 25;
        }

        return 0;
    }

    @Override
    public String getFlag() {
        return "HIGH_RISK_MERCHANT";
    }
}