package com.mhrglobal.payment;

import com.mhrglobal.clients.PaymentClient;
import com.mhrglobal.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankPaymentService implements PaymentService {
    private final PaymentClient paymentClient;
    Logger logger = LoggerFactory.getLogger(BankPaymentService.class);

    public BankPaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @Override
    public boolean requestPayment(Employee employee) {
        this.paymentClient.processPayment(employee.getEmployeeId(), employee.totalSalary());
        logger.info("Bank Payment called, employeeId: {} ", employee.getEmployeeId());
        return true;
    }
}
