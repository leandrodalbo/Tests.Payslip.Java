package com.mhrglobal.print;

import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.Payslip;

import java.util.UUID;

public interface PrintService {
    void requestPrinting(EmployeeRole role, UUID employeeId);
}
