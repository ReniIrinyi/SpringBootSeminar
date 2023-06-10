package com.springboot.restcrudapi.RestCrudApi.dao;

import com.springboot.restcrudapi.RestCrudApi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
     List<Employee> listAll();

     Employee findById(int id);

     Employee save(Employee employee);

     void deleteById(int id);
}
