package com.bug.dao;

import com.bug.model.Bug;

import java.util.List;


public interface BugDao {
    Bug findById(int id);

    void insert(Bug bug);

    void delete(Bug bug);

    List<Bug> findAll();
}
