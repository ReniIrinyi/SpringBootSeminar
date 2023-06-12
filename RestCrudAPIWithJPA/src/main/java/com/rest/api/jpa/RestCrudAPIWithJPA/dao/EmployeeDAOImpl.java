package com.rest.api.jpa.RestCrudAPIWithJPA.dao;

import com.rest.api.jpa.RestCrudAPIWithJPA.entity.EmployeeEntity;
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
    public List<EmployeeEntity> listAll() {
        TypedQuery<EmployeeEntity> query=entityManager.createQuery("from EmployeeEntity",EmployeeEntity.class);
        return query.getResultList();
    }

    @Override
    public EmployeeEntity findById(int id) {
       return entityManager.find(EmployeeEntity.class, id);
    }

    @Override
    public EmployeeEntity addNewEmployee(EmployeeEntity employee) {
        EmployeeEntity employeeDB= entityManager.merge(employee);
        return employeeDB;
    }

    @Override
    public void deleteEmployeeById(int id) {
       entityManager.remove(entityManager.find(EmployeeEntity.class, id));
    }
}
