package com.spring.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDAO;
import com.spring.models.Student;

import coim.spring.rowmapper.StudentRowMapper;

public class StudentDAOImpl implements StudentDAO {
	////
	// for xml config
	private DataSource dataSource;
	////
	private JdbcTemplate jdbcTemplate;
	
	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
	}
	@Override
	public List<Student> getAllStudents() {
		String sql="SELECT * FROM `student`";
		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		
		Object[] studentInfo = 
			{student.getStudent_id(),student.getName(),
					student.getAge(),student.getCity()};
		
		String sql="INSERT INTO `student`(`student_id`, `name`, `age`, `city`) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,studentInfo);
		System.out.println("inserted successfully !");
		
	}

	@Override
	public Student getStudentById(int id) {

		String sql="SELECT `id`,`student_id`, `name`, `age`, `city` FROM `student` WHERE `id`=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new StudentRowMapper());
	}
	
	@Override
	public int update(Student student) {

		String sql="UPDATE `student` SET `student_id`='"+student.getStudent_id()
		+"',`name`='"+student.getName()+"',`age`='"+student.getAge()
		+"',`city`='"+student.getCity()+"' WHERE `id`="+student.getId();
		return jdbcTemplate.update(sql);
	}

	@Override
	public int delete(int id) {

		String sql="DELETE FROM `student` WHERE `id`="+id;
		return jdbcTemplate.update(sql);
	}
	
	// for xml config
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}


}
