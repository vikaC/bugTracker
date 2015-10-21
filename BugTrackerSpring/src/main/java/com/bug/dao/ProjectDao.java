package com.bug.dao;

import com.bug.model.Project;

import java.util.List;

/**
 * Created by vita on 10/21/15.
 */
public interface ProjectDao {
    Project findById(int id);

    Project findByName(String name);

    void insert(Project employee);

    void delete(Project employee);

    void deleteByName(String name);

    List<Project> findAll();
}
