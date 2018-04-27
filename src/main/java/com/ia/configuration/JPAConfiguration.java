package com.ia.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA Configuration
 * @author Thales Goncalves
 */

@Configuration
@EnableTransactionManagement
public class JPAConfiguration {
	
	@Autowired
	private Environment env;

	@Bean
	@Profile("default")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName( env.getRequiredProperty( "dev.db.driver" ) );
		dataSource.setUrl( env.getRequiredProperty( "dev.db.url" ) );
		dataSource.setUsername( env.getRequiredProperty( "dev.db.username" ) );
		dataSource.setPassword( env.getRequiredProperty( "dev.db.password" ) );
		
		return dataSource;
	}
	
	/**
	 * DB Connection and mysql configuration
	 * @return factorybean configuration
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(dataSource);

		final Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.proc.param_null_passing", "true");
		factoryBean.setJpaProperties(properties);

		factoryBean.setPackagesToScan("com.ia");

		return factoryBean;
	}

	/**
	 * Manager for databese transactions
	 * @param emf EntityManagerFactory
	 * @return transaction manager
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

		return new JpaTransactionManager(emf);
	}

}
