package com.demo.springboot.Rest_Crud_API.rest;

import com.demo.springboot.Rest_Crud_API.dao.EmployeeDAO;
import com.demo.springboot.Rest_Crud_API.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;
    public EmployeeRestController(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
