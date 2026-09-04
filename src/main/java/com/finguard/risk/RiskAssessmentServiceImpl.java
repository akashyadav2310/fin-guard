package com.finguard.risk;

import com.finguard.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAssessmentServiceImpl
        implements RiskAssessmentService {

    private final List<RiskRule> riskRules;

    public RiskAssessmentServiceImpl(List<RiskRule> riskRules) {
        this.riskRules = riskRules;
    }

    @Override
    public RiskResult assessRisk(Transaction transaction) {

        int totalScore = 0;
        List<String> flags = new ArrayList<>();

        for (RiskRule rule : riskRules) {

            int score = rule.evaluate(transaction);

            if (score > 0) {
                totalScore += score;
                flags.add(rule.getFlag());
            }
        }

        int riskScore = Math.min(totalScore, 100);

        String riskLevel = determineRiskLevel(riskScore);
        String decision = determineDecision(riskScore);

        return new RiskResult(
                riskScore,
                riskLevel,
                decision,
                flags
        );
    }

    private String determineRiskLevel(int riskScore) {

        if (riskScore <= 30) {
            return "LOW";
        }

        if (riskScore <= 60) {
            return "MEDIUM";
        }

        return "HIGH";
    }

    private String determineDecision(int riskScore) {

        if (riskScore <= 30) {
            return "APPROVE";
        }

        if (riskScore <= 60) {
            return "REVIEW";
        }

        return "REVIEW";
    }
}