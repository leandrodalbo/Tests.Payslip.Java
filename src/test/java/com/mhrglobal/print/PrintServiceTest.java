package com.mhrglobal.print;


import com.mhrglobal.domain.EmployeeRole;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class PrintServiceTest {

    @Test
    public void shouldProcessEmployeePayment() {
        PrintService paymentService = PrintService.getInstance(EmployeeRole.ENGINEER);

        assertThat(paymentService.requestPrinting(UUID.randomUUID())).isNotNull();
    }
}