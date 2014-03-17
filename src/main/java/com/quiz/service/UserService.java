package com.quiz.service;

import java.util.List;

import com.quiz.entity.User;

public interface UserService {
	
	public boolean saveOrUpdateUser(User user);
	
	public boolean deleteUser(User user);
	
	public List<User> findByName(String name);
	
	public List<User> fetchAllUser();

}
