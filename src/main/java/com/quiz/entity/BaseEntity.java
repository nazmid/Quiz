package com.quiz.entity;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Id;

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = -4321512860388097466L;
	
	@Id
	private T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

}
