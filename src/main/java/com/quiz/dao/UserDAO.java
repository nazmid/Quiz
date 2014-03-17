package com.quiz.dao;

import java.util.List;

import com.quiz.entity.User;

public interface UserDAO extends GenericDAO<User> {

	public List<User> findAll();
	
	public List<User> findByName(String name);
}
