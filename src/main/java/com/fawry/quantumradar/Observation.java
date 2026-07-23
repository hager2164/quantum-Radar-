package com.fawry.quantumradar;

import java.time.LocalDate;
import java.util.Objects;

public class Observation {
    private final String plateNumber;
    private final LocalDate date;
    private final CarType carType;
    private final double speed;
    private final boolean seatbeltFastened;

    public Observation(String plateNumber, LocalDate date, CarType carType, double speed, boolean seatbeltFastened) {
        this.plateNumber = Objects.requireNonNull(plateNumber, "plateNumber must not be null");
        this.date = Objects.requireNonNull(date, "date must not be null");
        this.carType = Objects.requireNonNull(carType, "carType must not be null");
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isSeatbeltFastened() {
        return seatbeltFastened;
    }
}
