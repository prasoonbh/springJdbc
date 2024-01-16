package com.springcore.jdbc.entities;

import java.util.List;

import com.spring.jdbc.Student;

public interface StudentDao 
{
   public int insert(Student student);
   
   public int change(Student student);
   
   public int delete(int studentId);
   
   public Student getStudent (int StudentId);
   
   public List<Student> getAllStudents();
}
