package com.mhrglobal.payment;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class BankPaymentService implements PaymentService {
    private static final BankPaymentService instance = new BankPaymentService();
    Logger logger = LoggerFactory.getLogger(BankPaymentService.class);
    private EmployeeService employeeService;

    private BankPaymentService() {
    }

    public static PaymentService getInstance(EmployeeRole role) {
        instance.setEmployeeService(role);
        return instance;
    }

    @Override
    public boolean requestPayment(UUID employeeId) {
        logger.info("Bank Payment called, employeeId: {}, amount {} ", employeeId, employeeService.totalSalary(employeeId));
        return true;
    }

    private void setEmployeeService(EmployeeRole role) {
        this.employeeService = EmployeeService.getInstance(role);
    }
}
