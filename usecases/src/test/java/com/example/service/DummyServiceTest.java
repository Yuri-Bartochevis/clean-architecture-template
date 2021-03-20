package com.example.service;

import com.example.entities.Dummy;
import com.example.repository.DummyDataAccess;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class DummyServiceTest {

    @Mock private DummyDataAccess dummyDataAccess;

    private DummyService dummyService;

    private Dummy dummy;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dummyService = new DummyService(dummyDataAccess);

        dummy = Dummy.builder().id("id").build();

        when(dummyDataAccess.count()).thenReturn(1L);
    }
}
