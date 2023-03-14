package com.example.employee.service;

import com.example.employee.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> showEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
