package com.rest.api.jpa.RestCrudAPIWithJPA.dao;

import com.rest.api.jpa.RestCrudAPIWithJPA.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
     List<EmployeeEntity> listAll();

     EmployeeEntity findById(int id);

     EmployeeEntity addNewEmployee(EmployeeEntity employee);

     void deleteEmployeeById(int id);



}
