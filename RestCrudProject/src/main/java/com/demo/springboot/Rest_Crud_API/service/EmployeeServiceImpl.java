package com.demo.springboot.Rest_Crud_API.service;

import com.demo.springboot.Rest_Crud_API.dao.EmployeeDAO;
import com.demo.springboot.Rest_Crud_API.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return null;
    }

}
