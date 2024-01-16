package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springcore.jdbc.entities.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
      
       	System.out.println("My program started");
         // spring jdbc=> template 	
    
    	ApplicationContext context =
    			
    			new  AnnotationConfigApplicationContext(JdbcConfig.class);
    StudentDao studentDao =context.getBean("studentDao",StudentDao.class);
    
    // INSERT
    
  /*  Student student = new Student();
    student.setId(105);
    student.setName("Ram");
    student.setCity("Indore");
    int result = studentDao.insert(student);
    System.out.println("student added = "+result); */ 
    
    // Update
    
  /*  Student s = new Student();
    s.setId(107);
    s.setName("John");
    s.setCity("rau");
    
    int result = studentDao.change(s);
    System.out.println("Data changed " + result); */
    
    //delete 
       
   /* int r = studentDao.delete(105);
   System.out.println("Deleted rows "+r); */
    
    // SELECT
  // Student student = studentDao.getStudent(103);
    //System.out.println(student);
    
   List<Student> stt =  studentDao.getAllStudents();
    
    for(Student s: stt)
    {
    	System.out.println(s);
    }
    
    
    }
}
