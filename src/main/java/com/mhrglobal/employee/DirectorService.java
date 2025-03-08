package com.mhrglobal.employee;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;

import java.util.UUID;

public class DirectorService implements EmployeeService {
    private static final DirectorService instance = new DirectorService();
    private final EmployeeRepository repository = EmployeeRepository.getInstance();

    private DirectorService() {
    }

    public static DirectorService getInstance() {
        return instance;
    }

    @Override
    public double totalSalary(UUID employeeId) {
        Employee employee = repository.findDirectorById(employeeId);
        return employee.getBaseSalary();
    }

    @Override
    public double overtimePayed(UUID employeeId) {
        return 0;
    }

    @Override
    public Payslip createPayslip(UUID employeeId) {
        Employee employee = repository.findDirectorById(employeeId);
        return new Payslip(employee.getRole(), String.valueOf(employee.getBaseSalary()), String.valueOf(overtimePayed(employeeId)), String.valueOf(employee.getBaseSalary()));
    }

}
