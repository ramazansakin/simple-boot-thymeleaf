package com.sakinramazan.thymeleaf.service;

import com.sakinramazan.thymeleaf.domain.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee saveEmployee(Employee emp);

    boolean deleteEmployee(Long empId);

    Employee editEmployee(Employee emp);

    Employee findEmployee(Long empId);

    Collection<Employee> getAllEmployees();
}
