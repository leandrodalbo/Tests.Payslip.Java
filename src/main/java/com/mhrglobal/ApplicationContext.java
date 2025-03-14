package com.mhrglobal;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.employee.DirectorService;
import com.mhrglobal.employee.EmployeeService;
import com.mhrglobal.employee.EngineerService;
import com.mhrglobal.employee.ManagerService;
import com.mhrglobal.payment.BankPaymentService;
import com.mhrglobal.payment.PaymentService;
import com.mhrglobal.print.PayslipPrintService;
import com.mhrglobal.print.PrintService;
import com.mhrglobal.repository.EmployeeRepository;

public class ApplicationContext {

    private static final EmployeeRepository repository = new EmployeeRepository();

    private static final DirectorService directorService = new DirectorService(repository);
    private static final ManagerService managerService = new ManagerService(repository);
    private static final EngineerService engineerService = new EngineerService(repository);

    public static final PaymentService paymentService = new BankPaymentService(employeeService(EmployeeRole.NONE));

    public static final PrintService printService = new PayslipPrintService(employeeService(EmployeeRole.NONE));

    public static EmployeeService employeeService(EmployeeRole role) {
        return switch (role) {
            case ENGINEER -> engineerService;
            case MANAGER -> managerService;
            case DIRECTOR -> directorService;
            case NONE -> null;
        };
    }
}


