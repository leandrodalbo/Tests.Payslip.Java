package com.mhrglobal.payment;

import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public interface PaymentService {
    static PaymentService getInstance(EmployeeRole role) {
        return BankPaymentService.getInstance(role);
    }

    boolean requestPayment(UUID employeeId);
}
