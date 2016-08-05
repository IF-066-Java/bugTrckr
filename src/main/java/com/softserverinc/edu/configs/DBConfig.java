package com.softserverinc.edu.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Configuration for database, Hibernate, transactions
 * Created by ihorlt on 28.07.16.
 */


@EnableTransactionManagement
@Configuration
public class DBConfig extends WebMvcConfigurerAdapter {

    public static final Logger LOGGER = LoggerFactory.getLogger(DBConfig.class);

    //getting properties data from bean created in WebConfig class
    @Autowired
    private Environment environment;

    /**
     * Configures data source for database that will be used by other frameworks
     *
     * @return a driver instance that is connected with a database
     */
    @Bean
    public DataSource dataSource() {
        //Spring-jdbc library
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

    /**
     * Add Support of transactions. It is need @EnableTransactionManagement annotation
     *
     * @param entityManagerFactory
     * @return
     */
    @Bean
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    /**
     * Hibernate Manager configuration. For this configs it needs JpaVendorAdapter instance
     *
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        //Scan package for existing entities
        entityManagerFactory.setPackagesToScan("com.softserverinc.edu.entities");
        //For JPA properties
        Properties properties = new Properties();
        //create tables based on Java objects, first drop
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        //entityManagerFactory.setJpaProperties(properties);
        return entityManagerFactory;
    }

}
