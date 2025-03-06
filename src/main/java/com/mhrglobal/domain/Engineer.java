package com.mhrglobal.domain;

public class Engineer extends Employee {

    public Engineer(double baseSalary, int extraHours) {
        super(baseSalary, extraHours);
    }

    @Override
    public String role() {
        return "engineer";
    }

    @Override
    public double totalSalary() {
        return getBaseSalary() + overtimePayed();
    }

    @Override
    public double overtimePayed() {
        double totalForHours = HourRate.ENGINEER.getValue() * getExtraHours();
        return totalForHours + (totalForHours * PremiumOvertime.ENGINEER.getValue());
    }
}
