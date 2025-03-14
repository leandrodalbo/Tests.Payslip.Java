package com.mhrglobal.print;

import com.mhrglobal.ApplicationContext;
import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class PayslipPrintService implements PrintService {
    Logger logger = LoggerFactory.getLogger(PayslipPrintService.class);
    private EmployeeService employeeService;

    public PayslipPrintService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void requestPrinting(EmployeeRole role, UUID employeeId) {
        if(this.employeeService == null){
            setEmployeeService(role);
        }

        Payslip payslip = employeeService.createPayslip(employeeId);
        logger.info("Print called, Role: {}, BasePay: £{}, Overtime: £{}, Total: £{}", payslip.getRole(), payslip.getBasePay(), payslip.getOvertime(), payslip.getTotal());
        setEmployeeService(EmployeeRole.NONE);
    }

    private void setEmployeeService(EmployeeRole role) {
        this.employeeService = ApplicationContext.employeeService(role);
    }
}
