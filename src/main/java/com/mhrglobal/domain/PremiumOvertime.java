package com.mhrglobal.domain;

public enum PremiumOvertime {
    ENGINEER(0.35),
    MANAGER(0.25);

    private final double value;

    PremiumOvertime(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
