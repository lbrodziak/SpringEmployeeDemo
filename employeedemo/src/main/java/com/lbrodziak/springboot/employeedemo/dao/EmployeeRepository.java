package com.lbrodziak.springboot.employeedemo.dao;

import com.lbrodziak.springboot.employeedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
