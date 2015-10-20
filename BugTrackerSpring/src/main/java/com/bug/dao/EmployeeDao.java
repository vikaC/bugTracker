package com.bug.dao;

import com.bug.model.Employee;

import java.util.List;

/**
 * Created by vita on 10/20/15.
 */
public interface EmployeeDao {
    Employee findById(int id);

    Employee findByLogin(String login);

    void insert(Employee employee);

    void delete(Employee employee);

    void deleteByLogin(String login);

    List<Employee> findAll();
}
