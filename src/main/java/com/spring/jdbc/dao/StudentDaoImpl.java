package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.Student;
import com.springcore.jdbc.entities.StudentDao;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		
		 // insert query
    	
	    String query = "insert into student values(?,?,?)";
		int r  = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	    return r;
	}
	
	public int change(Student student)
	{
		// updating data
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
	  return r;	
	}


	public int delete(int studentId) {
		
		// deleting the data
		
				String query = "delete  from student where id =?";
				int r = this.jdbcTemplate.update(query,studentId);
				return r;
	}

	
	public Student getStudent(int StudentId) {
		// Selecting the sigle student data
		RowMapper<Student> rowMapper = new RowMapperImpl();
		String query = "select * from student where id = ?";
	 Student student=this.jdbcTemplate.queryForObject(query, rowMapper, StudentId);
		
		return student;
	}
	
	// Selecting multiple student
	public List<Student> getAllStudents() {
		
		String query= "Select * from student";
		
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return student;
		
	}

	

}
