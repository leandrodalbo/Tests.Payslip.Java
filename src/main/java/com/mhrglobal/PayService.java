package com.mhrglobal;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.payment.PaymentService;
import com.mhrglobal.print.PrintService;
import com.mhrglobal.repository.EmployeeRepository;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class PayService {

    private static final PaymentService paymentService = ApplicationContext.paymentService;
    private static final PrintService printService = ApplicationContext.printService;

    public static void main(String[] args) {

        Map<UUID, EmployeeRole> employees = Map.of(UUID.randomUUID(), EmployeeRole.MANAGER,
                UUID.randomUUID(), EmployeeRole.ENGINEER,
                UUID.randomUUID(), EmployeeRole.MANAGER,
                UUID.randomUUID(), EmployeeRole.ENGINEER,
                UUID.randomUUID(), EmployeeRole.DIRECTOR);

        employees.entrySet().forEach(it -> {
            paymentService.requestPayment(it.getValue(), it.getKey());
            printService.requestPrinting(it.getValue(), it.getKey());
        });

    }


}