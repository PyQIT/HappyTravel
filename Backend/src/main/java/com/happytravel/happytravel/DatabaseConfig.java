package com.happytravel.happytravel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class DatabaseConfig {

    @Value("${happytravel.spring.datasource.driverClassName}")
    private String DriverClassName;
    @Value("${happytravel.spring.datasource.url}")
    private String url;
    @Value("${happytravel.spring.datasource.username}")
    private String userName;
    @Value("${happytravel.spring.datasource.password}")
    private String password;
    @Value("${happytravel.packages.to.scan}")
    private String packages;
    @Value("${happytravel.show_sql}")
    private String showSql;
    @Value("${happytravel.hbm2ddl.auto}")
    private String crud;
    @Value("${happytravel.dialect}")
    private String dialect;
    @Value("${happytravel.h2dialect}")
    private String h2dialect;
    @Value("${happytravel.show.sql.decision}")
    private String showSqlDecision;
    @Value("${happytravel.set.crud}")
    private String crudDecision;


    @Bean
    @PostConstruct
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DriverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(packages);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty(crud, crudDecision);
        properties.setProperty(showSql, showSqlDecision);
        properties.setProperty(dialect, h2dialect);

        return properties;
    }

}
