package com.rest.api.jpa.RestCrudAPIWithJPA.service;

import com.rest.api.jpa.RestCrudAPIWithJPA.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> listAll();

    EmployeeEntity findById(int id);

    EmployeeEntity addNewEmployee(EmployeeEntity employee);

    void deleteEmployeeById(int id);
}
