package com.finguard.risk.rules;

import com.finguard.entity.Transaction;
import com.finguard.risk.RiskRule;
import org.springframework.stereotype.Component;

@Component
public class UnusualLocationRule implements RiskRule {

    private static final String NORMAL_LOCATION = "Pune";

    @Override
    public int evaluate(Transaction transaction) {

        if (transaction.getLocation() != null
                && !NORMAL_LOCATION.equalsIgnoreCase(
                transaction.getLocation())) {

            return 20;
        }

        return 0;
    }

    @Override
    public String getFlag() {
        return "UNUSUAL_LOCATION";
    }
}