package com.mhrglobal.domain;

public class Manager extends Employee {

    public Manager(double baseSalary, int extraHours) {
        super(baseSalary, extraHours);
    }

    @Override
    public double totalSalary() {
        return getBaseSalary() + overtimePayed();
    }

    @Override
    public double overtimePayed() {
        double totalForHours = HourRate.MANAGER.getValue() * getExtraHours();
        return totalForHours + (totalForHours * PremiumOvertime.MANAGER.getValue());
    }

    @Override
    public String role() {
        return "manager";
    }
}
