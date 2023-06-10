package com.demo.springboot.Rest_Crud_API.dao;

import com.demo.springboot.Rest_Crud_API.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
