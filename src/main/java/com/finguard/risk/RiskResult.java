package com.finguard.risk;

import java.util.List;

public class RiskResult {

    private final int riskScore;
    private final String riskLevel;
    private final String decision;
    private final List<String> flags;

    public RiskResult(int riskScore,
                      String riskLevel,
                      String decision,
                      List<String> flags) {

        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.decision = decision;
        this.flags = flags;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public String getDecision() {
        return decision;
    }

    public List<String> getFlags() {
        return flags;
    }
}