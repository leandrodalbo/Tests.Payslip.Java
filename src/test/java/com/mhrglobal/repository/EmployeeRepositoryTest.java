package com.mhrglobal.repository;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeRepositoryTest {
    EmployeeRepository repository = new EmployeeRepository();

    @Test
    void shouldFindADirectorByUUID() {
        Employee employee = repository.findDirectorById(UUID.randomUUID());

        assertThat(employee.getRole()).isEqualTo(EmployeeRole.DIRECTOR);
    }

    @Test
    void shouldFindAManagerByUUID() {
        Employee employee = repository.findManagerById(UUID.randomUUID());

        assertThat(employee.getRole()).isEqualTo(EmployeeRole.MANAGER);
    }

    @Test
    void shouldFindAnEngineerByUUID() {
        Employee employee = repository.findEngineerById(UUID.randomUUID());

        assertThat(employee.getRole()).isEqualTo(EmployeeRole.ENGINEER);
    }
}
