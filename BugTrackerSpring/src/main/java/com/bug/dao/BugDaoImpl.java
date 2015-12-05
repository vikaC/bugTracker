package com.bug.dao;

import com.bug.model.Bug;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("bugDao")
public class BugDaoImpl extends AbstractDao<Integer,Bug> implements BugDao {

    public void insert(Bug employee) {
        persist(employee);
    }

    public void delete(Bug employee) {
        delete(employee);
    }


    public Bug findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Bug> findAll() {
        Criteria findAllCriteria = createEntityCriteria();
        return (List<Bug>) findAllCriteria.list();
    }

}
