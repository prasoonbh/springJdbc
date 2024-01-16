package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.springcore.jdbc.entities.StudentDao;

@Configuration
@ComponentScan(basePackages= {"com.spring.jdbc"})
public class JdbcConfig 
{
	@Bean(name ={"ds"})
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean( name= { "jdbcTemplate"})
	public JdbcTemplate getTemplate()
	{
		  JdbcTemplate jdbcTemplate = new JdbcTemplate();
		  jdbcTemplate.setDataSource(getDataSource());
		  return jdbcTemplate;
	}
	@Bean(name= { "studentDao"})
	public StudentDao getStudentDao()
	{
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
		
	}
}
