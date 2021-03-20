package com.example.impl;

import com.example.repository.DummyDAO;
import com.example.repository.DummyDataAccess;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessImpl implements DummyDataAccess {

    private DummyDAO dao;

    public UserDataAccessImpl(DummyDAO dao) {
        this.dao = dao;
    }

    @Override
    public Long count() {
        return dao.countDummy();
    }

}
