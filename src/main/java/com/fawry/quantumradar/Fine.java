package com.fawry.quantumradar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Fine {
    private final String plateNumber;
    private final List<Violation> violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = Objects.requireNonNull(plateNumber, "plateNumber must not be null");
        Objects.requireNonNull(violations, "violations must not be null");
        if (violations.isEmpty()) {
            throw new IllegalArgumentException("violations must not be empty");
        }
        this.violations = new ArrayList<>(violations);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return Collections.unmodifiableList(violations);
    }

    public double getTotalAmount() {
        return violations.stream().mapToDouble(Violation::getFee).sum();
    }

    public void print() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + (int) getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation violation : violations) {
            System.out.println("- " + violation.getDescription() + " : " + (int) violation.getFee() + " EGP");
        }
    }
}
