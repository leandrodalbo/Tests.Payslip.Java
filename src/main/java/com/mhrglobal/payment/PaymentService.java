package com.mhrglobal.payment;

import com.mhrglobal.domain.Employee;

public interface PaymentService {
    boolean requestPayment(Employee employee);
}
