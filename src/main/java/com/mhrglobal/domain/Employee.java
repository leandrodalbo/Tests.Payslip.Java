package com.mhrglobal.domain;

import java.util.UUID;

public abstract class Employee {
    private static final int overtimeLimit = 60;

    private final double baseSalary;
    private final int extraHours;
    private final UUID employeeId = UUID.randomUUID();

    public Employee(double baseSalary, int extraHours) {
        this.baseSalary = baseSalary;
        this.extraHours = extraHours;

    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getExtraHours() {
        return Math.min(extraHours, overtimeLimit);
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public abstract String role();

    public abstract double totalSalary();

    public abstract double overtimePayed();

}
