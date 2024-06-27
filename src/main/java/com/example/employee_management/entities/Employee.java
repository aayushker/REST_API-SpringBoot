package com.example.employee_management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private long employeeId;
    private String name;
    private String designation;

    public Employee(long employeeId, String name, String designation) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
    }

    public Employee() {
        super();
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public String getName() {
        return name;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

}
