package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public interface EmployeeRepository {
    static EmployeeRepository getInstance(EmployeeRole role) {
        return switch (role) {
            case ENGINEER -> EngineerRepository.getInstance();
            case MANAGER -> ManagerRepository.getInstance();
            case DIRECTOR -> DirectorRepository.getInstance();
        };
    }

    Employee findById(UUID employeeId);
}
