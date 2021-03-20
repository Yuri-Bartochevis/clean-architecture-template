package com.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JdbcConfiguration {

    @Value("${db.ondok.url:jdbc:postgresql://db_ondok:5432/ondok}")
    String dataSourceUrl;

    @Value("${db.ondok.username:postgres}")
    String dataSourceUser;

    @Value("${db.ondok.pass:123456}")
    String dataSourcePassword;

    @Value("${datasource.leakDetectionThreshold:5000}")
    Long leakDetectionThreshold;

    @Value("${datasource.registerMbeans:true}")
    Boolean registerMbeans;

    @Value("${db.maxActive:5}")
    Integer maximumPoolSize;

    @Primary
    @Bean(name = "ondokDataSource", destroyMethod = "close")
    @ConditionalOnMissingBean({HikariDataSource.class})
    DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    private HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setRegisterMbeans(false);
        hikariConfig.setPoolName("springHikariCP");
        hikariConfig.setLeakDetectionThreshold(leakDetectionThreshold);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        hikariConfig.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");

        Properties properties = new Properties();
        properties.put("url", dataSourceUrl);
        properties.put("user", dataSourceUser);
        properties.put("password", dataSourcePassword);
        hikariConfig.setDataSourceProperties(properties);

        return hikariConfig;
    }

}
