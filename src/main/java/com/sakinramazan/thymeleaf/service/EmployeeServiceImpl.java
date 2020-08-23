package com.sakinramazan.thymeleaf.service;

import com.sakinramazan.thymeleaf.domain.Employee;
import com.sakinramazan.thymeleaf.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public boolean deleteEmployee(Long empId) {
        Optional<Employee> byId = employeeRepository.findById(empId);
        if (byId.isPresent()) {
            employeeRepository.delete(empId);
            return true;
        }
        return false;
    }

    @Override
    public Employee editEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return (Collection<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(Long empId) {
        return employeeRepository.findOne(empId);
    }

}
