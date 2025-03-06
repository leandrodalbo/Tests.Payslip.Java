package com.mhrglobal.payment;

import com.mhrglobal.clients.PaymentClient;
import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.times;

class BankPaymentServiceTest {

    private final Employee employee = new Engineer(234.4, 5);
    private PaymentService paymentService;

    @Mock
    private PaymentClient paymentClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new BankPaymentService(paymentClient);
    }

    @Test
    public void shouldProcessEmployeePayment() {
        doNothing().when(paymentClient).processPayment(any(), anyDouble());

        assertTrue(paymentService.requestPayment(employee));

        verify(paymentClient, times(1)).processPayment(any(), anyDouble());

    }

}