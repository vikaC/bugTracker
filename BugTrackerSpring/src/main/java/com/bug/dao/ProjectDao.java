package com.bug.dao;

import com.bug.model.Project;

import java.util.List;


public interface ProjectDao {
    Project findById(int id);

    Project findByName(String name);

    void insert(Project employee);

    void delete(Project employee);

    void deleteByName(String name);

    List<Project> findAll();
}
