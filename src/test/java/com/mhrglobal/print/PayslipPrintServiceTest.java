package com.mhrglobal.print;

import com.mhrglobal.clients.PrinterClient;
import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;

class PayslipPrintServiceTest {

    private PrintService printService;

    @Mock
    private PrinterClient printerClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        printService = new PayslipPrintService(printerClient);
    }

    @Test
    public void shouldPrintPayslip() {
        doNothing().when(printerClient).print(anyString());
        Employee employee = new Manager(234.4, 4);

        printService.requestPrinting(employee.role(), String.valueOf(employee.getBaseSalary()),
                String.valueOf(employee.overtimePayed()),
                String.valueOf(employee.totalSalary())
        );

        verify(printerClient, times(1)).print(anyString());

    }
}