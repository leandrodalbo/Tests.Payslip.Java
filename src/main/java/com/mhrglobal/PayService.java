package com.mhrglobal;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.payment.PaymentService;
import com.mhrglobal.print.PrintService;

import java.util.UUID;

public class PayService {

    private static final PayService instance = new PayService();

    private PaymentService paymentService;
    private PrintService printService;

    private PayService() {
    }

    public static PayService getInstance(EmployeeRole role) {
        instance.setPaymentService(role);
        instance.setPrintService(role);
        return instance;
    }

    public static void main(String[] args) {
        PayService payService = PayService.getInstance(EmployeeRole.ENGINEER);
        payService.payAndPrintPayslip(UUID.randomUUID());


        payService = PayService.getInstance(EmployeeRole.MANAGER);
        payService.payAndPrintPayslip(UUID.randomUUID());

        payService = PayService.getInstance(EmployeeRole.DIRECTOR);
        payService.payAndPrintPayslip(UUID.randomUUID());

    }

    public void payAndPrintPayslip(UUID employee) {
        this.paymentService.requestPayment(employee);
        this.printService.requestPrinting(employee);
    }

    private void setPaymentService(EmployeeRole role) {
        this.paymentService = PaymentService.getInstance(role);
    }

    private void setPrintService(EmployeeRole role) {
        this.printService = PrintService.getInstance(role);
    }
}