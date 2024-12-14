package com.ps.microservices.employeeservice.controller;

import com.ps.microservices.employeeservice.dto.EmployeeDto;
import com.ps.microservices.employeeservice.model.Employee;
import com.ps.microservices.employeeservice.repository.EmployeeRepository;
import com.ps.microservices.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long departmentId){
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }
}
