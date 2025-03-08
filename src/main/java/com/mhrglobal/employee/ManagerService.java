package com.mhrglobal.employee;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.HourRate;
import com.mhrglobal.domain.PremiumOvertime;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;

import java.util.UUID;

public class ManagerService implements EmployeeService {
    private static final ManagerService instance = new ManagerService();
    public final int managerOvertimeLimit = 60;
    private final EmployeeRepository repository = EmployeeRepository.getInstance();

    private ManagerService() {
    }

    public static ManagerService getInstance() {
        return instance;
    }

    @Override
    public double totalSalary(UUID employeeId) {
        Employee employee = repository.findManagerById(employeeId);
        return employee.getBaseSalary() + overtimePayed(employee);
    }

    @Override
    public double overtimePayed(UUID employeeId) {
        Employee employee = repository.findManagerById(employeeId);
        double totalForHours = HourRate.MANAGER.getValue() * extraHours(employee.getExtraHours());
        return totalForHours + (totalForHours * PremiumOvertime.MANAGER.getValue());
    }

    @Override
    public Payslip createPayslip(UUID employeeId) {
        Employee employee = repository.findManagerById(employeeId);
        return new Payslip(employee.getRole(), String.valueOf(employee.getBaseSalary()), String.valueOf(overtimePayed(employee)), String.valueOf(this.totalSalary(employee)));
    }

    private double totalSalary(Employee employee) {
        return employee.getBaseSalary() + overtimePayed(employee);
    }

    private double overtimePayed(Employee employee) {
        double totalForHours = HourRate.MANAGER.getValue() * extraHours(employee.getExtraHours());
        return totalForHours + (totalForHours * PremiumOvertime.MANAGER.getValue());
    }

    private int extraHours(int hours) {
        return Math.min(hours, managerOvertimeLimit);
    }

}
