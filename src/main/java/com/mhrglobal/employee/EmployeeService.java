package com.mhrglobal.employee;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;

import java.util.UUID;

public interface EmployeeService {
    static EmployeeService getInstance(EmployeeRole role) {
        return switch (role) {
            case ENGINEER -> EngineerService.getInstance();
            case MANAGER -> ManagerService.getInstance();
            case DIRECTOR -> DirectorService.getInstance();
        };
    }

    double totalSalary(UUID employeeId);

    double overtimePayed(UUID employeeId);

    Payslip createPayslip(UUID employeeId);
}
