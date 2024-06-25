package com.example.employee_management.services;
import com.example.employee_management.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public Employee addEmployee(Employee employee);
    public Employee deleteEmployee(int employeeId);
    public Employee updateEmployee(Employee employee);

    Employee updateEmployee(int employeeId, Employee updatedEmployeeData);
}
