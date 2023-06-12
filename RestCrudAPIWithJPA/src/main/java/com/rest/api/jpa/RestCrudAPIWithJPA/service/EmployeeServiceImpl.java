package com.rest.api.jpa.RestCrudAPIWithJPA.service;

import com.rest.api.jpa.RestCrudAPIWithJPA.dao.EmployeeDAO;
import com.rest.api.jpa.RestCrudAPIWithJPA.entity.EmployeeEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeEntity> listAll() {
        return employeeDAO.listAll();
    }

    @Override
    public EmployeeEntity findById(int id) {
        return employeeDAO.findById(id);
    }
    @Transactional
    @Override
    public EmployeeEntity addNewEmployee(EmployeeEntity employee) {
        return employeeDAO.addNewEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }
}
