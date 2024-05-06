package com.lbrodziak.springboot.employeedemo.dao;

import com.lbrodziak.springboot.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findEmployeeById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
