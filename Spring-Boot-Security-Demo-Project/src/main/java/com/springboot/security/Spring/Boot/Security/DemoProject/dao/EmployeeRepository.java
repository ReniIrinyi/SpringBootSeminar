package com.springboot.security.Spring.Boot.Security.DemoProject.dao;

import com.springboot.security.Spring.Boot.Security.DemoProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
