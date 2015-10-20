package com.bug.service;

import com.bug.model.Employee;

import java.util.List;

/**
 * Created by vita on 10/21/15.
 */
public interface EmployeeService {
    Employee findById(int id);

    Employee findByLogin(String login);

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

    void deleteByLogin(String login);

    boolean isLoginUnique(String login);

    List<Employee> findAll();

    boolean isLoginPasswordMatch(String login, String password);

}
