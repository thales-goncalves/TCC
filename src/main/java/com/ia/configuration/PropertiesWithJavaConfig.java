package com.ia.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Essa classe é importante para conseguir ler o arquivo de Properties que vai guardar 
 * os dados de Conexão do Banco de dados.
 * 
 * @Configuration
 * @author Thales Goncalves
 *
 */
@Configuration
@PropertySource("classpath:db.properties")
public class PropertiesWithJavaConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}