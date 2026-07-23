package com.fawry.quantumradar;

public class TruckSpeedRule extends SpeedRule {
    public TruckSpeedRule(double maxSpeed, double feePerViolation) {
        super(CarType.TRUCK, maxSpeed, feePerViolation);
    }
}
