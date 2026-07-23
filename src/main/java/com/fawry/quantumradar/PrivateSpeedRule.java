package com.fawry.quantumradar;

public class PrivateSpeedRule extends SpeedRule {
    public PrivateSpeedRule(double maxSpeed, double feePerViolation) {
        super(CarType.PRIVATE, maxSpeed, feePerViolation);
    }
}
