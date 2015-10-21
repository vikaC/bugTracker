package com.bug.dao;

import com.bug.model.Project;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vita on 10/21/15.
 */

@Repository("projectDao")
public class ProjectDaoImpl extends AbstractDao<Integer,Project> implements ProjectDao {
    public void insert(Project employee) {
        persist(employee);
    }

    public void delete(Project employee) {
        delete(employee);
    }

    public void deleteByName(String name) {
        Query deleteQuery = getSession().createQuery("delete from project where name = :name");
        deleteQuery.setString("name", name);
    }

    public Project findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        Criteria findAllCriteria = createEntityCriteria();
        return (List<Project>) findAllCriteria.list();
    }

    public Project findByName(String login) {
        Criteria findCriteria = createEntityCriteria();
        findCriteria.add(Restrictions.eq("login", login));
        return (Project) findCriteria.uniqueResult();
    }
}
