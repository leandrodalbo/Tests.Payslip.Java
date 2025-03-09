package com.mhrglobal.payment;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.employee.EmployeeService;
import com.mhrglobal.employee.EngineerService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class BankPaymentServiceTest {

    @Test
    public void shouldProcessEmployeePayment() {
        UUID employeeId = UUID.randomUUID();

        EmployeeService employeeService = mock(EngineerService.class);
        when(employeeService.totalSalary(employeeId)).thenReturn(167.5);

        BankPaymentService underTest = new BankPaymentService(employeeService);

        underTest.requestPayment(EmployeeRole.ENGINEER, employeeId);

        verify(employeeService, times(1)).totalSalary(employeeId);
    }
}