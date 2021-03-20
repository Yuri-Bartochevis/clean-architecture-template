package com.example.service;

import com.example.repository.DummyDataAccess;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    private DummyDataAccess dummyDataAccess;

    public DummyService(DummyDataAccess dummyDataAccess) {
        this.dummyDataAccess = dummyDataAccess;
    }

    public Long count() {
        return dummyDataAccess.count();
    }
}
