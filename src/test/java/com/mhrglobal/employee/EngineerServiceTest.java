package com.mhrglobal.employee;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineerServiceTest {

    private final EmployeeRepository repository = new EmployeeRepository();

    private final EngineerService service = new EngineerService(repository);

    @Test
    void shouldCalculateAnEngineerTotalSalary() {
        double totalSalary = service.totalSalary(UUID.randomUUID());

        assertThat(totalSalary).isEqualTo(167.5);
    }

    @Test
    void shouldCreateAnEngineerPayslip() {

        Payslip payslip = service.createPayslip(UUID.randomUUID());

        assertThat(payslip.getRole()).isEqualTo(EmployeeRole.ENGINEER);
        assertThat(payslip.getOvertime()).isEqualTo("67.5");
        assertThat(payslip.getBasePay()).isEqualTo("100.0");
        assertThat(payslip.getTotal()).isEqualTo("167.5");
    }

    @Test
    void shouldCalculateAnEngineerExtraHours() {
        double result = service.overtimePayed(UUID.randomUUID());

        assertThat(result).isEqualTo(67.5);
    }
}
