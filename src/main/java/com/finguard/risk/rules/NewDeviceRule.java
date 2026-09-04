package com.finguard.risk.rules;

import com.finguard.entity.Transaction;
import com.finguard.risk.RiskRule;
import org.springframework.stereotype.Component;

@Component
public class NewDeviceRule implements RiskRule {

    @Override
    public int evaluate(Transaction transaction) {

        if (transaction.getDeviceId() != null
                && transaction.getDeviceId().startsWith("NEW-")) {

            return 25;
        }

        return 0;
    }

    @Override
    public String getFlag() {
        return "NEW_DEVICE";
    }
}