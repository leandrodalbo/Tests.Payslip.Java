package com.mhrglobal.payment;

import com.mhrglobal.domain.EmployeeRole;

import java.util.UUID;

public interface PaymentService {
    void requestPayment(EmployeeRole role, UUID employeeId);
}
