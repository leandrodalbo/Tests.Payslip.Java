package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public class DirectorRepository implements EmployeeRepository {

    private static DirectorRepository instance = new DirectorRepository();

    private DirectorRepository() {
    }

    public static DirectorRepository getInstance() {
        return instance;
    }

    @Override
    public Employee findById(UUID employeeId) {
        return new Employee(UUID.randomUUID(), EmployeeRole.DIRECTOR, 540.5, 0);
    }
}
