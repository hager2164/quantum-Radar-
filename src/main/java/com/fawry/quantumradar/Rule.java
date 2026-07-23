package com.fawry.quantumradar;

public interface Rule {
    /**
     * Evaluates the observation against this rule.
     *
     * @return a violation when the rule is broken, otherwise {@code null}
     */
    Violation check(Observation observation);
}
