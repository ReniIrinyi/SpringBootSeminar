package com.springboot.restcrudapi.RestCrudApi.service;

import com.springboot.restcrudapi.RestCrudApi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
