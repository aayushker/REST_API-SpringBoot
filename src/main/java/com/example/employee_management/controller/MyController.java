package com.example.employee_management.controller;

import com.example.employee_management.entities.Employee;
import com.example.employee_management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    public EmployeeService employeeService;
    @GetMapping("/home")
    public String home(){
        return "This is the home page";
    }

    //get the employees
    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return this.employeeService.getEmployeeById(employeeId);
    }

    @PostMapping(value = "/employees", consumes = "application/json")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable int employeeId){
        return this.employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        return this.employeeService.updateEmployee(employeeId, employee);
    }
}
