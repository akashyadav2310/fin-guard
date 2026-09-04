package com.finguard.risk;

import com.finguard.entity.Transaction;

public interface RiskAssessmentService {

    RiskResult assessRisk(Transaction transaction);
}