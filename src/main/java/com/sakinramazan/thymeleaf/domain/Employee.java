package com.sakinramazan.thymeleaf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "emp_name", length = 50)
    private String empName;

    @Column(name = "emp_designation", length = 50)
    private String empDesignation;

    @Column(name = "emp_salary")
    private Float empSalary;

}
