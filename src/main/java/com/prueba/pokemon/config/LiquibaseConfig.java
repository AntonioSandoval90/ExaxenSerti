package com.prueba.pokemon.config;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class LiquibaseConfig {

    @Autowired
    private Environment environment;

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(environment.getRequiredProperty("spring.liquibase.change-log"));
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    @Bean
    public javax.sql.DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        return dataSource;
    }
}