package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeRepositoryTest {

    @Test
    void shouldFindADirectorByUUID() {
        EmployeeRepository repository = EmployeeRepository.getInstance(EmployeeRole.DIRECTOR);

        Employee employee = repository.findById(UUID.randomUUID());

        assertThat(employee.getRole()).isEqualTo(EmployeeRole.DIRECTOR);
    }

    @Test
    void shouldFindAManagerByUUID() {
        EmployeeRepository repository = EmployeeRepository.getInstance(EmployeeRole.MANAGER);

        Employee employee = repository.findById(UUID.randomUUID());

        assertThat(employee.getRole()).isEqualTo(EmployeeRole.MANAGER);
    }

    @Test
    void shouldFindAnEngineerByUUID() {
        EmployeeRepository repository = EmployeeRepository.getInstance(EmployeeRole.ENGINEER);

        Employee employee = repository.findById(UUID.randomUUID());

        assertThat(employee.getRole()).isEqualTo(EmployeeRole.ENGINEER);
    }
}
