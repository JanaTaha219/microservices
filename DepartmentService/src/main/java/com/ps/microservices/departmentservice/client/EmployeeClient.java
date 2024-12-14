package com.ps.microservices.departmentservice.client;

import com.ps.microservices.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/api/v1/employee/department/{departmentId}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long departmentId);


}
