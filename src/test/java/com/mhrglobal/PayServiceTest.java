package com.mhrglobal;


import com.mhrglobal.domain.Director;
import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.Engineer;
import com.mhrglobal.domain.Manager;
import com.mhrglobal.payment.PaymentService;
import com.mhrglobal.print.PrintService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

class PayServiceTest {

    private PayService payService;

    @Mock
    private PrintService printService;

    @Mock
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payService = new PayService(paymentService, printService);
    }

    @Test
    public void shouldProcessASetOfEmployees() {
        doNothing().when(printService).requestPrinting(anyString(), anyString(), anyString(), anyString());
        when(paymentService.requestPayment(any())).thenReturn(true);

        Set<Employee> employees = Set.of(new Engineer(343.4, 3),
                new Manager(546.0, 2),
                new Director(890.0));

        payService.processEmployeesSalaries(employees);

        verify(paymentService, times(3)).requestPayment(any());
        verify(printService, times(3)).requestPrinting(anyString(), anyString(), anyString(), anyString());
    }
}