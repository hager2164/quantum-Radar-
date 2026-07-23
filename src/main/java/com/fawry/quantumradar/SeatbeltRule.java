package com.fawry.quantumradar;

public class SeatbeltRule implements Rule {
    private final double fee;

    public SeatbeltRule(double fee) {
        this.fee = fee;
    }

    @Override
    public Violation check(Observation observation) {
        if (observation.isSeatbeltFastened()) {
            return null;
        }

        return new Violation("Seatbelt not fastened", fee, getClass().getSimpleName());
    }
}
