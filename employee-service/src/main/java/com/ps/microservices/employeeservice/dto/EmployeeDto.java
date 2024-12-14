package com.ps.microservices.employeeservice.dto;

import lombok.*;

@Setter @Getter @AllArgsConstructor
@NoArgsConstructor @ToString
public class EmployeeDto {
    Long departmentId;
    String name;
    int age;
    String position;
}
