package com.aspire.gkeep;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.aspire.gkeep")
public class ApplicationConfiguration {
	
	/*Instead of using xml configuration, following is the configuration of the datasource (mysql)
	 * Alternatively, we can use embedded database for dev with configuration that 
	 * creates HSQL embedded database and pre-populates it with SQL scripts using EmbeddedDatabaseBuilder*/
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/keep");
		dataSource.setUsername("root");
		dataSource.setPassword("aspire@123");
		return dataSource;
	}
}
