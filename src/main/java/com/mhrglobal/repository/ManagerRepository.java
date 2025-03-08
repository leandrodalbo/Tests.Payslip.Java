package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public class ManagerRepository implements EmployeeRepository {

    private static final ManagerRepository instance = new ManagerRepository();

    private ManagerRepository() {
    }

    public static ManagerRepository getInstance() {
        return instance;
    }

    @Override
    public Employee findById(UUID employeeId) {
        return new Employee(employeeId, EmployeeRole.MANAGER, 440.5, 4);
    }
}
