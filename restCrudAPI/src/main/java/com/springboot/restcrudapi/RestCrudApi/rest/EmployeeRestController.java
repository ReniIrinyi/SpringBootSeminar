package com.springboot.restcrudapi.RestCrudApi.rest;

import com.springboot.restcrudapi.RestCrudApi.entity.Employee;
import com.springboot.restcrudapi.RestCrudApi.service.EmployeeService;
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
    public List<Employee> listAll(){
       return employeeService.listAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        try{
            return employeeService.findById(id);
        } catch (RuntimeException e){
            throw new RuntimeException("Try with an other id");
        }
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
            employee.setId(0);
            Employee dbEmployee=employeeService.save(employee);
            return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee=employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee tempEmployee=employeeService.findById(id);
        if(tempEmployee==null){
            System.out.println("Employee not found" + id);
        }
        employeeService.deleteById(id);
        return "Deleted employee: "+ tempEmployee.toString();
    }
}
