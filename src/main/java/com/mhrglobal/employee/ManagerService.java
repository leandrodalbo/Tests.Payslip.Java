package com.mhrglobal.employee;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.EmployeeRole;
import com.mhrglobal.domain.HourRate;
import com.mhrglobal.domain.PremiumOvertime;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;

import java.util.UUID;

public class ManagerService implements EmployeeService {
    private static final ManagerService instance = new ManagerService();
    public final int managerOvertimeLimit = 60;
    private EmployeeRepository repository;

    private ManagerService() {
    }

    public static ManagerService getInstance(EmployeeRole role) {
        instance.setRepository(role);
        return instance;
    }

    @Override
    public double totalSalary(UUID employeeId) {
        Employee employee = repository.findById(employeeId);
        return employee.getBaseSalary() + overtimePayed(employee);
    }

    @Override
    public double overtimePayed(UUID employeeId) {
        Employee employee = repository.findById(employeeId);
        double totalForHours = HourRate.MANAGER.getValue() * extraHours(employee.getExtraHours());
        return totalForHours + (totalForHours * PremiumOvertime.MANAGER.getValue());
    }

    @Override
    public Payslip createPayslip(UUID employeeId) {
        Employee employee = repository.findById(employeeId);
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

    private void setRepository(EmployeeRole role) {
        this.repository = EmployeeRepository.getInstance(role);
    }
}
