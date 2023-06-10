package com.springboot.restcrudapi.RestCrudApi.dao;

import com.springboot.restcrudapi.RestCrudApi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> listAll() {
        TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees=query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee=entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee=entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
