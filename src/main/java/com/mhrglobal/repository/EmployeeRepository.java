package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public class EmployeeRepository {

    public Employee findDirectorById(UUID employeeId) {
        return new Employee(UUID.randomUUID(), EmployeeRole.DIRECTOR, 540.5, 0);
    }

    public Employee findEngineerById(UUID employeeId) {
        return new Employee(employeeId, EmployeeRole.ENGINEER, 100, 10);
    }

    public Employee findManagerById(UUID employeeId) {
        return new Employee(employeeId, EmployeeRole.MANAGER, 440.5, 4);
    }

}
