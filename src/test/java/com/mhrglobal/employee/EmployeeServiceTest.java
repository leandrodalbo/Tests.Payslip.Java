package com.mhrglobal.employee;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeServiceTest {

    @Test
    void shouldCalculateAnEngineerTotalSalary() {
        EmployeeService service = EmployeeService.getInstance(EmployeeRole.ENGINEER);

        double totalSalary = service.totalSalary(UUID.randomUUID());

        assertThat(totalSalary).isEqualTo(167.5);
    }

    @Test
    void shouldCalculateAManagerExtraHours() {
        EmployeeService service = EmployeeService.getInstance(EmployeeRole.MANAGER);

        double overtimePayed = service.overtimePayed(UUID.randomUUID());

        assertThat(overtimePayed).isEqualTo(30.0);
    }

    @Test
    void shouldCreateADirectorPayslip() {
        EmployeeService service = EmployeeService.getInstance(EmployeeRole.DIRECTOR);

        Payslip payslip = service.createPayslip(UUID.randomUUID());

        assertThat(payslip.getRole()).isEqualTo(EmployeeRole.DIRECTOR);
        assertThat(payslip.getOvertime()).isEqualTo("0.0");
        assertThat(payslip.getBasePay()).isEqualTo("540.5");
        assertThat(payslip.getTotal()).isEqualTo("540.5");
    }
}
