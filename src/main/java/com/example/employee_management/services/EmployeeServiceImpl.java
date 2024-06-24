package com.example.employee_management.services;
import com.example.employee_management.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees;
    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "john@doe.com"));
        employees.add(new Employee(2, "Mary Smith", "mary@smith.com"));
        employees.add(new Employee(3, "Jane Doe", "jane@doe.com"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
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
}