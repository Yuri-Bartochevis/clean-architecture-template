package com.example.entities;

import org.junit.Before;

public class DummyTest {

    private Dummy dummy;

    @Before
    public void setUp() {
        dummy = Dummy.builder().id("1").build();
    }
}
