package com.mhrglobal.employee;

import com.mhrglobal.domain.Employee;
import com.mhrglobal.domain.HourRate;
import com.mhrglobal.domain.PremiumOvertime;
import com.mhrglobal.domain.Payslip;
import com.mhrglobal.repository.EmployeeRepository;

import java.util.UUID;

public class EngineerService implements EmployeeService {
    public final int engineerOvertimeLimit = 60;

    private final EmployeeRepository repository;

    public EngineerService(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public double totalSalary(UUID employeeId) {
        Employee employee = repository.findEngineerById(employeeId);
        return employee.getBaseSalary() + overtimePayed(employee);
    }

    @Override
    public double overtimePayed(UUID employeeId) {
        Employee employee = repository.findEngineerById(employeeId);
        double totalForHours = HourRate.ENGINEER.getValue() * extraHours(employee.getExtraHours());
        return totalForHours + (totalForHours * PremiumOvertime.ENGINEER.getValue());
    }

    @Override
    public Payslip createPayslip(UUID employeeId) {
        Employee employee = repository.findEngineerById(employeeId);
        return new Payslip(employee.getRole(), String.valueOf(employee.getBaseSalary()), String.valueOf(overtimePayed(employee)), String.valueOf(this.totalSalary(employee)));
    }


    private double overtimePayed(Employee employee) {
        double totalForHours = HourRate.ENGINEER.getValue() * extraHours(employee.getExtraHours());
        return totalForHours + (totalForHours * PremiumOvertime.ENGINEER.getValue());
    }

    private double totalSalary(Employee employee) {
        return employee.getBaseSalary() + overtimePayed(employee);
    }

    private int extraHours(int hours) {
        return Math.min(hours, engineerOvertimeLimit);
    }

}
