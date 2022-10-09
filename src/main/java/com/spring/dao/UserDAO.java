package com.spring.dao;

import javax.sql.DataSource;

import com.spring.models.User;

public interface UserDAO {
	

	void register(User user); 
	public void setDataSource(DataSource dataSource);
}
