package com.quiz.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity("users")
public class User extends BaseEntity<ObjectId> {

	private static final long serialVersionUID = 1831496215264749555L;

	private String name;

	private String surname;

	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
