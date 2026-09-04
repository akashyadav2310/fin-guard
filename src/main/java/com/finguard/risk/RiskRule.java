package com.finguard.risk;

import com.finguard.entity.Transaction;

public interface RiskRule {

    int evaluate(Transaction transaction);

    String getFlag();
}