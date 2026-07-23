package com.fawry.quantumradar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class QuRadar {
    private final List<Rule> rules;
    private final List<Fine> issuedFines;

    public QuRadar() {
        this.rules = new ArrayList<>();
        this.issuedFines = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(Objects.requireNonNull(rule, "rule must not be null"));
    }

    public void processObservation(Observation observation) {
        Objects.requireNonNull(observation, "observation must not be null");

        List<Violation> violations = new ArrayList<>();

        for (Rule rule : rules) {
            Violation violation = rule.check(observation);
            if (violation != null) {
                violations.add(violation);
            }
        }

        if (!violations.isEmpty()) {
            issuedFines.add(new Fine(observation.getPlateNumber(), violations));
        }
    }

    public Map<String, Double> getAllFines() {
        Map<String, Double> finesByPlate = new HashMap<>();

        for (Fine fine : issuedFines) {
            finesByPlate.merge(fine.getPlateNumber(), fine.getTotalAmount(), Double::sum);
        }

        return Collections.unmodifiableMap(finesByPlate);
    }

    public List<Fine> getIssuedFines() {
        return List.copyOf(issuedFines);
    }

    public Map<String, Integer> getAllViolatedRulesCount() {
        Map<String, Integer> ruleCounts = new HashMap<>();

        for (Fine fine : issuedFines) {
            for (Violation violation : fine.getViolations()) {
                ruleCounts.merge(violation.getRuleName(), 1, Integer::sum);
            }
        }

        return Collections.unmodifiableMap(ruleCounts);
    }
}
