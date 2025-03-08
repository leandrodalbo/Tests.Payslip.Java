package com.mhrglobal.domain;

public class Payslip {
    private final EmployeeRole role;
    private final String basePay;
    private final String overtime;
    private final String total;

    public Payslip(EmployeeRole role, String basePay, String overtime, String total) {
        this.role = role;
        this.basePay = basePay;
        this.overtime = overtime;
        this.total = total;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public String getBasePay() {
        return basePay;
    }

    public String getOvertime() {
        return overtime;
    }

    public String getTotal() {
        return total;
    }
}
