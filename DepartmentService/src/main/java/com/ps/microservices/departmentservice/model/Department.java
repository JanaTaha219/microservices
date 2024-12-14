package com.ps.microservices.departmentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @OneToMany
    private List<Employee> employees = new ArrayList<>();

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
