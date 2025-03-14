package com.mhrglobal.print;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.employee.EmployeeService;

import com.mhrglobal.employee.ManagerService;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class PayslipPrintServiceTest {

    @Test
    public void shouldProcessEmployeePayslip() {
        UUID employeeId = UUID.randomUUID();

        EmployeeService employeeService = mock(ManagerService.class);
        when(employeeService.createPayslip(employeeId)).thenReturn(new Payslip(EmployeeRole.MANAGER, "454.0", "56.0", "510.0"));

        PrintService underTest = new PayslipPrintService(employeeService);

        underTest.requestPrinting(EmployeeRole.MANAGER, employeeId);

        verify(employeeService, times(1)).createPayslip(employeeId);
    }
}