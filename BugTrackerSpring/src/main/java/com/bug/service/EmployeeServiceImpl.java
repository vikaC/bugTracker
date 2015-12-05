package com.bug.service;

import com.bug.dao.EmployeeDao;
import com.bug.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeDao dao;

    @Override
    public boolean isLoginPasswordMatch(String login, String password) {
        Employee employee = dao.findByLogin(login);
        return (employee != null & employee.getPassword().equals(password));
    }

    @Override
    public boolean isLoginUnique(String login) {
        Employee employee = dao.findByLogin(login);
        return (employee != null & !employee.getLogin().equals(login));
    }

    @Override
    public Employee findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Employee findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Employee employee) {
        dao.delete(employee);
    }

    @Override
    public void deleteByLogin(String login) {
        dao.deleteByLogin(login);
    }

    @Override
    public void insert(Employee employee) {
        dao.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        Employee entity = dao.findById(employee.getId());
        if (entity != null) {
            entity.setPassword(employee.getPassword());
            entity.setPosition(employee.getPosition());
            entity.setSurname(employee.getSurname());
            entity.setName(employee.getName());
            entity.setLogin(employee.getLogin());
        }
    }
}
