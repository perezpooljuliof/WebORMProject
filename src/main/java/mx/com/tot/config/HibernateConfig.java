package mx.com.tot.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author JULIO.PEREZ
 */

@Configuration
@ComponentScan({"mx.com.tot.dao,mx.com.tot.service"}) //Services and repositories to be scanned.
@EnableTransactionManagement
@PropertySource(value = {"classpath:mysql.properties"})
public class HibernateConfig {
    @Autowired
    private Environment environment;
    
    public HibernateConfig() {
        System.out.println("HibernateConfig()>>>>>>");
    }
    
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        //Entities to be scanned
        sessionFactoryBean.setPackagesToScan(new String[] {"mx.com.tot.dto"});
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return sessionFactoryBean;
    }
    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        String user = environment.getProperty("jdbc.username");
        String password = environment.getProperty("jdbc.password");
        String driverClassName = environment.getProperty("jdbc.driver");
        String url = environment.getProperty("jdbc.url");
        System.out.println("url:" + url);
        
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public Properties getHibernateProperties() {
        String dialect = environment.getProperty("hibernate.dialect");

        Properties prop = new Properties();
        prop.put("hibernate.dialect", dialect);
        //prop.put("hibernate.current_session_context_class", "thread");
        return prop;
    }
}
