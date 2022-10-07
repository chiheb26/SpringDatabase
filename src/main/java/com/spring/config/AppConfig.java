package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.dao.StudentDAO;
import com.spring.dao.impl.StudentDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.spring.controllers")
public class AppConfig implements WebMvcConfigurer{
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/views/");
		ivr.setSuffix(".jsp");
		ivr.setOrder(0);
		return ivr;
	}
	
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false");
		dataSource.setUsername("root");
		//dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public StudentDAO getUserDao() {
		return new StudentDAOImpl(getDataSource());
	}
	
	
}
