package com.mhrglobal.domain;


public class Director extends Employee {

    public Director(double baseSalary) {
        super(baseSalary, 0);
    }

    @Override
    public double totalSalary() {
        return getBaseSalary();
    }

    @Override
    public double overtimePayed() {
        return 0;
    }

    @Override
    public String role() {
        return "director";
    }

}
