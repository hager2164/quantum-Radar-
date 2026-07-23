package com.fawry.quantumradar;

abstract class SpeedRule implements Rule {
    private final CarType applicableCarType;
    private final double maxSpeed;
    private final double feePerViolation;

    protected SpeedRule(CarType applicableCarType, double maxSpeed, double feePerViolation) {
        this.applicableCarType = applicableCarType;
        this.maxSpeed = maxSpeed;
        this.feePerViolation = feePerViolation;
    }

    @Override
    public Violation check(Observation observation) {
        if (observation.getCarType() != applicableCarType || observation.getSpeed() <= maxSpeed) {
            return null;
        }

        String description = String.format(
                "speed of %.0f exceeded max allowed %.0f",
                observation.getSpeed(),
                maxSpeed
        );
        return new Violation(description, feePerViolation, getClass().getSimpleName());
    }
}
