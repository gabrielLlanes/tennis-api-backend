package com.example.tennisBackendCode;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(System.getenv("spring.datasource.url"))
                .username(System.getenv("spring.datasource.username"))
                .password(System.getenv("spring.datasource.password"))
                .build();
    }
}
