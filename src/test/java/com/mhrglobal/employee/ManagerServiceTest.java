package com.mhrglobal.employee;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagerServiceTest {
    private final EmployeeRepository repository = new EmployeeRepository();

    private final ManagerService service = new ManagerService(repository);


    @Test
    void shouldCalculateAManagerExtraHours() {
        double overtimePayed = service.overtimePayed(UUID.randomUUID());

        assertThat(overtimePayed).isEqualTo(30.0);
    }

    @Test
    void shouldCalculateAManagerTotalSalary() {
        double totalSalary = service.totalSalary(UUID.randomUUID());

        assertThat(totalSalary).isEqualTo(470.5);
    }

    @Test
    void shouldCreateAManagerPayslip() {

        Payslip payslip = service.createPayslip(UUID.randomUUID());

        assertThat(payslip.getRole()).isEqualTo(EmployeeRole.MANAGER);
        assertThat(payslip.getOvertime()).isEqualTo("30.0");
        assertThat(payslip.getBasePay()).isEqualTo("440.5");
        assertThat(payslip.getTotal()).isEqualTo("470.5");
    }

}
