package com.bug.service;

import com.bug.dao.ProjectDao;
import com.bug.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao dao;

    @Override
    public Project findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Project findByName(String login) {
        return dao.findByName(login);
    }

    @Override
    public List<Project> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Project employee) {
        dao.delete(employee);
    }

    @Override
    public void deleteByName(String login) {
        dao.deleteByName(login);
    }

    @Override
    public void insert(Project employee) {
        dao.insert(employee);
    }

    @Override
    public void update(Project employee) {
        Project entity = dao.findById(employee.getId());
        if (entity != null) {
            entity.setName(employee.getName());
            entity.setDueDate(employee.getDueDate());
            entity.setStartDate(employee.getStartDate());
        }
    }
}
