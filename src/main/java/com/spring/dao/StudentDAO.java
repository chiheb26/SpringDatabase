package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.spring.models.Student;

public interface StudentDAO {
	
	List<Student> getAllStudents();
	void saveStudent(Student student);
	Student getStudentById(int id);
	int update(Student student);
	int delete(int id);
	
	// For xml config
	void setDataSource(DataSource dataSource);
	
}
