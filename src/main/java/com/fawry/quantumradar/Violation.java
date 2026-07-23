package com.fawry.quantumradar;

public class Violation {
    private final String description;
    private final double fee;
    private final String ruleName;

    public Violation(String description, double fee, String ruleName) {
        this.description = description;
        this.fee = fee;
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public double getFee() {
        return fee;
    }

    public String getRuleName() {
        return ruleName;
    }
}
