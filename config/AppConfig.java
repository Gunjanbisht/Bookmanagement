package com.bookmanagement.config;
	
	import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.ComponentScans;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.core.env.Environment;
    import org.springframework.jdbc.datasource.DriverManagerDataSource;
    import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	import static org.hibernate.cfg.Environment.*;
	@Configuration
	@PropertySource("classpath:db.properties")
	@EnableTransactionManagement
	@ComponentScans(value = {
			@ComponentScan("com.bookmanagement.dao"),
			@ComponentScan("com.bookmanagement.service")
	})
	public class AppConfig {
		
		@Autowired
		private Environment evn;
		
		@Bean
			public LocalSessionFactoryBean sessionFactory() {
		        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		        sessionFactory.setDataSource(dataSource());
		        sessionFactory.setPackagesToScan(new String[] { "com.bookmanagement.model" });
		        sessionFactory.setHibernateProperties(hibernateProperties());
		        return sessionFactory;
		     }
		     
		    @Bean
		    public DataSource dataSource() {
		        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		        dataSource.setDriverClassName(evn.getRequiredProperty("jdbc.driverClassName"));
		        dataSource.setUrl(evn.getRequiredProperty("jdbc.url"));
		        dataSource.setUsername(evn.getRequiredProperty("jdbc.username"));
		        dataSource.setPassword(evn.getRequiredProperty("jdbc.password"));
		        return dataSource;
		    }
		     
		    private Properties hibernateProperties() {
		        Properties properties = new Properties();
		        properties.put("hibernate.dialect", evn.getRequiredProperty("hibernate.dialect"));
		        properties.put("hibernate.show_sql", evn.getRequiredProperty("hibernate.show_sql"));
		        properties.put("hibernate.format_sql", evn.getRequiredProperty("hibernate.format_sql"));
		        properties.put("hibernate.hbm2ddl.auto", evn.getRequiredProperty("hibernate.hbm2ddl.auto"));
		        return properties;        
		    }
		     
		    @Bean
		    @Autowired
		    public HibernateTransactionManager transactionManager(SessionFactory s) {
		       HibernateTransactionManager txManager = new HibernateTransactionManager();
		       txManager.setSessionFactory(s);
		       return txManager;
		    }
		
	}

	