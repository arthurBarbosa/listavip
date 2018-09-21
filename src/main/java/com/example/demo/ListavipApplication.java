package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListavipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListavipApplication.class, args);
	}
	
//	@Bean
//	public DataSource dataSource(){
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
//	    dataSource.setUsername("root");
//	    dataSource.setPassword("root");
//	    return dataSource;
	
	//configuracao pro postgresql
//	dataSource.setDriverClassName("org.postgresql.Driver");
//	dataSource.setUrl("jdbc:postgresql://localhost:5432/listavip");
//	dataSource.setUsername("root");
//	dataSource.setPassword("root");
//	}
}
