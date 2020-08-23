package com.sakinramazan.thymeleaf.repository;

import com.sakinramazan.thymeleaf.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findById(Long id);
}