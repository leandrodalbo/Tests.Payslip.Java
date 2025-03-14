package com.mhrglobal.domain;

import java.util.UUID;

public class Employee {

    private final UUID employeeId;
    private final EmployeeRole role;
    private final double baseSalary;
    private final int extraHours;

    public Employee(UUID employeeId, EmployeeRole role, double baseSalary, int extraHours) {
        this.employeeId = employeeId;
        this.role = role;
        this.baseSalary = baseSalary;
        this.extraHours = extraHours;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getExtraHours() {
        return extraHours;
    }
}
