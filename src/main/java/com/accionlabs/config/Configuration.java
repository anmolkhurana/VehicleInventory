package com.accionlabs.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.accionlabs.entity"})
@EnableTransactionManagement
public class Configuration {
	
	private static final String dbDriver ="org.h2.Driver";
	private static final String dbDialect = "org.hibernate.dialect.H2Dialect";
	private static final String dbURL = "jdbc:h2:tcp://localhost/~/mydb";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbURL);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dbDialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Bean
	public SessionFactory getsessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(dataSource);
		sessionFactory.addProperties(getProperties());
		sessionFactory.scanPackages("com.accionlabs.entity");
		return sessionFactory.buildSessionFactory();
	}
			
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
}
