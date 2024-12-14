package com.ps.microservices.departmentservice.controller;

import com.ps.microservices.departmentservice.client.EmployeeClient;
import com.ps.microservices.departmentservice.dto.DepartmentDto;
import com.ps.microservices.departmentservice.model.Department;
import com.ps.microservices.departmentservice.model.Employee;
import com.ps.microservices.departmentservice.servic.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    DepService depService;
    @Autowired
    EmployeeClient employeeClient;

    @GetMapping()
    public ResponseEntity<List<Department>> getAllDepartments(){
        return depService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return depService.getDepartmentById(id);
    }

    @PostMapping()
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return depService.saveDepartment(departmentDto);
    }

    @GetMapping("/withEmployee")
    public List<Department> findAllWithEmployees(){
        List<Department> departments = depService.getAllDepartmentss();
        departments.forEach(
                department -> department.setEmployees(employeeClient.getEmployeesByDepartmentId(department.getId()))
        );
        return departments;
    }

    @GetMapping("/xx")
    public List<Employee> xx(){
        Long b= 1L;
        return employeeClient.getEmployeesByDepartmentId(b);
    }


}
