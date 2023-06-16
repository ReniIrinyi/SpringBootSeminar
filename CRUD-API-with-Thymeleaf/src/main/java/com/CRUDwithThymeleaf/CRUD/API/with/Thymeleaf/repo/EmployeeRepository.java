package com.CRUDwithThymeleaf.CRUD.API.with.Thymeleaf.repo;

import com.CRUDwithThymeleaf.CRUD.API.with.Thymeleaf.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
