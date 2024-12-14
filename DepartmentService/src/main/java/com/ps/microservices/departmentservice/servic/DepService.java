package com.ps.microservices.departmentservice.servic;

import com.ps.microservices.departmentservice.dto.DepartmentDto;
import com.ps.microservices.departmentservice.mapper.EntityDtoConverter;
import com.ps.microservices.departmentservice.model.Department;
import com.ps.microservices.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class DepService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EntityDtoConverter converter;

    public ResponseEntity<List<Department>> getAllDepartments(){
        log.info("returned all departments");
        return new ResponseEntity<>(departmentRepository.findAll(), HttpStatus.OK);
    }

    public List<Department> getAllDepartmentss(){
        log.info("returned all departments");
        return departmentRepository.findAll();
    }

    public ResponseEntity<Department> getDepartmentById(Long id){
        log.info("returned a department");
        return new ResponseEntity<>(departmentRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<DepartmentDto> saveDepartment(DepartmentDto departmentDto){
        log.info("saved a department");
        departmentRepository.save(converter.convertToEntity(departmentDto, Department.class));
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }


}
