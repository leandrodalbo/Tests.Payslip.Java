package com.mhrglobal.print;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class PayslipPrintService implements PrintService {

    private static final PayslipPrintService instance = new PayslipPrintService();
    Logger logger = LoggerFactory.getLogger(PayslipPrintService.class);
    private EmployeeService employeeService;

    private PayslipPrintService() {
    }

    public static PrintService getInstance(EmployeeRole role) {
        instance.setEmployeeService(role);
        return instance;
    }

    @Override
    public Payslip requestPrinting(UUID employeeId) {
        Payslip payslip = employeeService.createPayslip(employeeId);
        logger.info("Print called, Role: {}, BasePay: £{}, Overtime: £{}, Total: £{}", payslip.getRole(), payslip.getBasePay(), payslip.getOvertime(), payslip.getTotal());
        return payslip;
    }

    private void setEmployeeService(EmployeeRole role) {
        this.employeeService = EmployeeService.getInstance(role);
    }
}
