package com.ps.microservices.employeeservice.service;

import com.ps.microservices.employeeservice.dto.EmployeeDto;
import com.ps.microservices.employeeservice.mapper.EntityDtoConverter;
import com.ps.microservices.employeeservice.model.Employee;
import com.ps.microservices.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EntityDtoConverter converter;
    public ResponseEntity<Employee> getEmployeeById(Long id){
        return new ResponseEntity<>(employeeRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<EmployeeDto> addEmployee(EmployeeDto employeeDto){
        employeeRepository.save(converter.convertToEntity(employeeDto, Employee.class));
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
