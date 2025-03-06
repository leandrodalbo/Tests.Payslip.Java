package com.mhrglobal;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.payment.PaymentService;
import com.mhrglobal.print.PrintService;

import java.util.Set;


public class PayService {

    private final PaymentService paymentService;
    private final PrintService printService;

    public PayService(PaymentService paymentService, PrintService printService) {
        this.paymentService = paymentService;
        this.printService = printService;
    }

    public void processEmployeesSalaries(Set<Employee> employeeSet) {

        for (Employee employee : employeeSet) {
            this.paymentService.requestPayment(employee);
            this.printService.requestPrinting(employee.role(), String.valueOf(employee.getBaseSalary()),
                    String.valueOf(employee.overtimePayed()),
                    String.valueOf(employee.totalSalary()));
        }
    }

}