package com.mhrglobal.payment;


import com.mhrglobal.domain.EmployeeRole;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {


    @Test
    public void shouldProcessEmployeePayment() {
        PaymentService paymentService = PaymentService.getInstance(EmployeeRole.MANAGER);

        assertThat(paymentService.requestPayment(UUID.randomUUID())).isTrue();
    }

}