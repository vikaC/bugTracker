package com.bug.service;

import com.bug.dao.BugDao;
import com.bug.model.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service(value = "bugService")
public class BugServiceImpl implements BugService {

    @Autowired
    private BugDao dao;

    @Override
    public Bug findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Bug> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Bug employee) {
        dao.delete(employee);
    }


    @Override
    public void insert(Bug employee) {
        dao.insert(employee);
    }

    @Override
    public void update(Bug employee) {
        Bug entity = dao.findById(employee.getBugId());
        if (entity != null) {
            entity.setName(employee.getName());
            entity.setDueDate(employee.getDueDate());
            entity.setCreationDate(employee.getCreationDate());
            entity.setDescription(employee.getDescription());
        }
    }
}
