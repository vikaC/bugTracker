package com.bug.dao;

import com.bug.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vita on 10/20/15.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

    public void insert(Employee employee) {
        persist(employee);
    }

    public void delete(Employee employee) {
        delete(employee);
    }

    public void deleteByLogin(String login) {
        Query deleteQuery = getSession().createQuery("delete from employee where login = :login");
        deleteQuery.setString("login", login);
    }

    public Employee findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        Criteria findAllCriteria = createEntityCriteria();
        return (List<Employee>) findAllCriteria.list();
    }

    public Employee findByLogin(String login) {
        Criteria findCriteria = createEntityCriteria();
        findCriteria.add(Restrictions.eq("login", login));
        return (Employee) findCriteria.uniqueResult();
    }
}
