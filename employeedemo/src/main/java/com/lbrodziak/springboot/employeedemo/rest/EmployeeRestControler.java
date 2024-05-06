package com.lbrodziak.springboot.employeedemo.rest;

import com.lbrodziak.springboot.employeedemo.entity.Employee;
import com.lbrodziak.springboot.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestControler {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestControler(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findALl(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);
        //if employee is not in db throw an exception
        if (employee == null){
            throw new RuntimeException("Employee not found! "+employeeId);
        }
        else {
            return employee;
        }
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){

        //in case employee id is set in JSON we reset it to 0
        employee.setId(0);
        return employeeService.save(employee);

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        //get the employee data form db
        Employee employee = employeeService.findEmployeeById(employeeId);
        //if employee dos not exist throw exception
        if (employee == null){
            throw new RuntimeException("Employee not found: "+employeeId);
        } else {
            //delete the employee
            employeeService.deleteById(employeeId);
            return "Deleted employee: "+ employeeId;
        }
    }
}
