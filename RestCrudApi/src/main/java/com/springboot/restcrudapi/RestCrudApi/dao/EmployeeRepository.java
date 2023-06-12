package com.springboot.restcrudapi.RestCrudApi.dao;

import com.springboot.restcrudapi.RestCrudApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
