package com.example.employee_management.dao;

import com.example.employee_management.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesDao extends JpaRepository<Employee, Integer> {
}
