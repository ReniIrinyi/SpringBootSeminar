package com.demo.springboot.Rest_Crud_API.service;

import com.demo.springboot.Rest_Crud_API.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
