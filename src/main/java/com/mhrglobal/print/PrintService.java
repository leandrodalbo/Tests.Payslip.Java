package com.mhrglobal.print;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;

import java.util.UUID;

public interface PrintService {
    static PrintService getInstance(EmployeeRole role) {
        return PayslipPrintService.getInstance(role);
    }

    Payslip requestPrinting(UUID employeeId);
}
