package com.fawry.quantumradar;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        QuRadar radar = new QuRadar();
        radar.addRule(new TruckSpeedRule(60, 300));
        radar.addRule(new PrivateSpeedRule(80, 300));
        radar.addRule(new SeatbeltRule(100));

        radar.processObservation(new Observation(
                "ABC1234",
                LocalDate.now(),
                CarType.PRIVATE,
                94,
                false
        ));

        radar.processObservation(new Observation(
                "XYZ7890",
                LocalDate.now(),
                CarType.TRUCK,
                75,
                true
        ));

        radar.processObservation(new Observation(
                "OK1111",
                LocalDate.now(),
                CarType.PRIVATE,
                70,
                true
        ));

        System.out.println("=== Issued Fine Details ===");
        for (Fine fine : radar.getIssuedFines()) {
            fine.print();
            System.out.println();
        }

        System.out.println("=== All Fines by Plate ===");
        for (Map.Entry<String, Double> entry : radar.getAllFines().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().intValue() + " EGP");
        }

        System.out.println();
        System.out.println("=== Violated Rules Count ===");
        for (Map.Entry<String, Integer> entry : radar.getAllViolatedRulesCount().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
