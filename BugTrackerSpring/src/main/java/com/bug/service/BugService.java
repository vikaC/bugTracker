package com.bug.service;


import com.bug.model.Bug;

import java.util.List;

public interface BugService {

    Bug findById(int id);

    void insert(Bug bug);

    void update(Bug bug);

    void delete(Bug bug);

    List<Bug> findAll();

}
