package com.ps.microservices.departmentservice.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;
    private String name;

    public DepartmentDto(String name){
        this.name = name;
    }
}
