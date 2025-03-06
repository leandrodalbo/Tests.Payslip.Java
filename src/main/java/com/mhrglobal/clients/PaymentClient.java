package com.mhrglobal.clients;

import java.util.UUID;

public interface PaymentClient {
    void processPayment(UUID employeeId, double amount);
}
