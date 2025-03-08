package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public class EngineerRepository implements EmployeeRepository {

    private static EngineerRepository instance = new EngineerRepository();

    private EngineerRepository() {
    }

    public static EngineerRepository getInstance() {
        return instance;
    }

    @Override
    public Employee findById(UUID employeeId) {
        return new Employee(employeeId, EmployeeRole.ENGINEER, 100, 10);
    }
}
