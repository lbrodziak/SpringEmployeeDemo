package com.lbrodziak.springboot.employeedemo.service;

import com.lbrodziak.springboot.employeedemo.dao.EmployeeRepository;
import com.lbrodziak.springboot.employeedemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else{
            throw new RuntimeException("Did not fin emplyee id: " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
         employeeRepository.deleteById(id);
    }
}
