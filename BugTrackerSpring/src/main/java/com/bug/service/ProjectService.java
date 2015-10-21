package com.bug.service;

import com.bug.model.Project;

import java.util.List;

/**
 * Created by vita on 10/21/15.
 */
public interface ProjectService {
    Project findById(int id);

    Project findByName(String login);

    void insert(Project employee);

    void update(Project employee);

    void delete(Project employee);

    void deleteByName(String login);

    List<Project> findAll();

}
