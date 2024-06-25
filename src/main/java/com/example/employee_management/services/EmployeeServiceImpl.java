package com.example.employee_management.services;
import com.example.employee_management.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees;
    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Willy Du", "Jhadu Pocha"));
        employees.add(new Employee(2, "Mary Smith", "Mali"));
        employees.add(new Employee(3, "Hi Jack", "Population controller"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        if (id == 0){
            return (Employee) employees;
        }
        Employee employee = null;
        for (Employee e : employees) {
            if (e.getEmployeeId()  == id){
                employee = e;
                break;
            }
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmployeeId() == employeeId) {
                iterator.remove();
                break;
            }
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee updatedEmployeeData) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                if (updatedEmployeeData.getName() != null) {
                    e.setName(updatedEmployeeData.getName());
                }
                if (updatedEmployeeData.getDesignation() != null) {
                    e.setDesignation(updatedEmployeeData.getDesignation());
                }
                return e;
            }
        }
        return null;
    }

}