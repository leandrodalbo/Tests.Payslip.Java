package com.mhrglobal.employee;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectorServiceTest {

    private final EmployeeRepository repository = new EmployeeRepository();

    private final DirectorService service = new DirectorService(repository);

    @Test
    void shouldCreateADirectorPayslip() {

        Payslip payslip = service.createPayslip(UUID.randomUUID());

        assertThat(payslip.getRole()).isEqualTo(EmployeeRole.DIRECTOR);
        assertThat(payslip.getOvertime()).isEqualTo("0.0");
        assertThat(payslip.getBasePay()).isEqualTo("540.5");
        assertThat(payslip.getTotal()).isEqualTo("540.5");
    }

    @Test
    void directorOvertimeIsNotAllowed() {
        double result = service.overtimePayed(UUID.randomUUID());

        assertThat(result).isEqualTo(0.0);
    }

    @Test
    void directorTotalSalaryIsTheSameABaseSalary() {
        double result = service.totalSalary(UUID.randomUUID());

        assertThat(result).isEqualTo(540.5);
    }
}
