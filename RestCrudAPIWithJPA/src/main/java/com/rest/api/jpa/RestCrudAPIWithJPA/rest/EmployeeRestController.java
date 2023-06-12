package com.rest.api.jpa.RestCrudAPIWithJPA.rest;

import com.rest.api.jpa.RestCrudAPIWithJPA.entity.EmployeeEntity;
import com.rest.api.jpa.RestCrudAPIWithJPA.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> listAll(){
      return employeeService.listAll();
   }
    @GetMapping("/employees/{id}")
    public EmployeeEntity findById(@PathVariable int id) {
        return employeeService.findById(id);
    }
    @PostMapping("/employees")
    public EmployeeEntity addNewEmployee(EmployeeEntity employee) {
        employee.setId(0);
        return employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

}
