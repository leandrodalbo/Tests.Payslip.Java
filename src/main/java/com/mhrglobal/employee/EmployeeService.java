package com.mhrglobal.employee;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;

import java.util.UUID;

public interface EmployeeService {
    static EmployeeService getInstance(EmployeeRole role) {
        return switch (role) {
            case ENGINEER -> EngineerService.getInstance(role);
            case MANAGER -> ManagerService.getInstance(role);
            case DIRECTOR -> DirectorService.getInstance(role);
        };
    }

    double totalSalary(UUID employeeId);

    double overtimePayed(UUID employeeId);

    Payslip createPayslip(UUID employeeId);
}
