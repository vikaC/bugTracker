package com.bug.dao;

import com.bug.model.Bug;

import java.util.List;

/**
 * Created by vita on 12/4/15.
 */
public interface BugDao {
    Bug findById(int id);

    void insert(Bug bug);

    void delete(Bug bug);

    List<Bug> findAll();
}
