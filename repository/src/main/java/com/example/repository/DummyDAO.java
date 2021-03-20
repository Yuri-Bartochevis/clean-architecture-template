package com.example.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import static java.util.Collections.emptyMap;

@Component
public class DummyDAO {
    private final JdbcTemplate jdcTemplate;

    public DummyDAO(@Qualifier("ondokDataSource") DataSource dataSource) {
        this.jdcTemplate = new JdbcTemplate(dataSource);
    }

    public Long countDummy() {
        return new NamedParameterJdbcTemplate(jdcTemplate)
                .queryForObject("SELECT COUNT(*) from doctor", emptyMap(), Long.class);
    }

}
