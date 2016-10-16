package mx.com.tot.mx.com.tot.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by elver on 1/08/16.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"mx.com.tot.dao", "mx.com.tot.bo"})
@PropertySource(value = {"classpath:hibernate.properties"})
public class HibernateConfig {

    @Autowired
    private Environment environment;

    public HibernateConfig() {
        System.out.println("HibernateConfig()>>>>>");
    }

    @Bean(name = "datasource")
    public BasicDataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));

        System.out.println("datasource:" + dataSource.getUrl());

        return dataSource;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));

        return properties;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[] {"mx.com.tot.dto"});
        sessionFactory.setHibernateProperties(getProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory session) {
        HibernateTransactionManager txMannager = new HibernateTransactionManager();
        txMannager.setSessionFactory(session);

        return txMannager;
    }
}
