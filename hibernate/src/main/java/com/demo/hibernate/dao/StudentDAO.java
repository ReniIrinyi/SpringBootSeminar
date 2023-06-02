package com.demo.hibernate.dao;

import com.demo.hibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    void delete(int id);
    int deleteAllStudent();
    Student find(int index);
    List<Student>findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);

}
