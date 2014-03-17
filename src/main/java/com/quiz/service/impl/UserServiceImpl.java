package com.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dao.UserDAO;
import com.quiz.entity.User;
import com.quiz.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	// test case yazarken farkli senaryolar olusturabilmek icin boolean donulmustur.
	public boolean saveOrUpdateUser(User user) {
		if(user == null){
			return false;
		}
		return userDAO.saveOrUpdate(user);
	}

	public boolean deleteUser(User user) {
		if(user == null){
			return false;
		}
		return userDAO.deleteEntity(user);
	}

	public List<User> fetchAllUser() {
		return userDAO.findAll();
	}

	@Override
	public List<User> findByName(String name) {
		return userDAO.findByName(name);
	}

}
