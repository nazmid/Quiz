package com.quiz.dao;

import java.io.Serializable;

import com.quiz.entity.User;

public interface GenericDAO<T extends Serializable> {
	
	boolean saveOrUpdate(T entity);
	
	boolean deleteEntity(User user);

}
