package com.mhrglobal.employee;

import com.mhrglobal.domain.Payslip;

import java.util.UUID;

public interface EmployeeService {

    double totalSalary(UUID employeeId);

    double overtimePayed(UUID employeeId);

    Payslip createPayslip(UUID employeeId);
}
