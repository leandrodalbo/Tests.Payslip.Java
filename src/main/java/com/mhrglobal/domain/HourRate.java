package com.mhrglobal.domain;

public enum HourRate {
    ENGINEER(5),
    MANAGER(6),
    DIRECTOR(7);

    private final double value;

    HourRate(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
