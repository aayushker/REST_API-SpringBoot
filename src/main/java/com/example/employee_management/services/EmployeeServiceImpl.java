package com.example.employee_management.services;

import com.example.employee_management.dao.EmployeesDao;
import com.example.employee_management.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesDao employeesDao;

    // List<Employee> employees;

    public EmployeeServiceImpl() {
//        // Uncomment for manual list initialization
        // employees = new ArrayList<>();
        // employees.add(new Employee(1, "Willy Du", "Jhadu Pocha"));
        // employees.add(new Employee(2, "Mary Smith", "Mali"));
        // employees.add(new Employee(3, "Hi Jack", "Population controller"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        // return employees;
        return employeesDao.findAll();
    }

//    @Override
//    public Employee getEmployeeById(int id) {
//        return null;
//    }

    @Override
    public Employee getEmployeeById(int id) {
        // if (id == 0) {
        //     // Returning the entire employees list casted to Employee is not valid,
        //     // hence commented out this incorrect implementation.
        //     // return (Employee) employees;
        // }

        // Employee employee = null;
        // for (Employee e : employees) {
        //     if (e.getEmployeeId() == id) {
        //         employee = e;
        //         break;
        //     }
        // }
        // return employee;

        // Using employeesDao to fetch employee by id
        Optional<Employee> employeeOptional = employeesDao.findById( id);
        return employeeOptional.orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employeeOptional = employeesDao.findById((int) id);
        return employeeOptional.orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        // Uncomment for manual addition
        // employees.add(employee);
        // return employee;

        return employeesDao.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        // Uncomment for manual deletion
        // boolean found = false;
        // Iterator<Employee> iterator = employees.iterator();
        // while (iterator.hasNext()) {
        //     Employee employee = iterator.next();
        //     if (employee.getEmployeeId() == employeeId) {
        //         iterator.remove();
        //         found = true;
        //         break;
        //     }
        // }
        // if (!found) {
        //     throw new IllegalArgumentException("Employee with ID " + employeeId + " not found.");
        // }

        boolean found = employeesDao.existsById(employeeId);
        if (!found) {
            throw new NoSuchElementException("Employee with ID " + employeeId + " not found.");
        }
        employeesDao.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        // This method is not implemented yet
        return null;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee updatedEmployeeData) {
        // Uncomment for manual update
        // for (Employee e : employees) {
        //     if (e.getEmployeeId() == employeeId) {
        //         if (updatedEmployeeData.getName() != null) {
        //             e.setName(updatedEmployeeData.getName());
        //         }
        //         if (updatedEmployeeData.getDesignation() != null) {
        //             e.setDesignation(updatedEmployeeData.getDesignation());
        //         }
        //         return e;
        //     }
        // }
        // return null;

        Optional<Employee> employeeOptional = employeesDao.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            if (updatedEmployeeData.getName() != null) {
                existingEmployee.setName(updatedEmployeeData.getName());
            }
            if (updatedEmployeeData.getDesignation() != null) {
                existingEmployee.setDesignation(updatedEmployeeData.getDesignation());
            }
            return employeesDao.save(existingEmployee);
        } else {
            throw new NoSuchElementException("Employee not found with id: " + employeeId);
        }
    }
}
