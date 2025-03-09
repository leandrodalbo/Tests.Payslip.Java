package com.mhrglobal.payment;

import com.mhrglobal.ApplicationContext;
import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class BankPaymentService implements PaymentService {
    Logger logger = LoggerFactory.getLogger(BankPaymentService.class);
    private EmployeeService employeeService = null;

    public BankPaymentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void requestPayment(EmployeeRole role, UUID employeeId) {
        if (employeeService == null) {
            setEmployeeService(role);
        }

        double totalToPay = employeeService.totalSalary(employeeId);
        logger.info("Bank Payment called, employeeId: {}, amount {} ", employeeId, totalToPay);

        setEmployeeService(EmployeeRole.NONE);
    }

    private void setEmployeeService(EmployeeRole role) {
        this.employeeService = ApplicationContext.employeeService(role);
    }
}
