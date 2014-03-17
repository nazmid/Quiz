package com.quiz.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quiz.entity.User;
import com.quiz.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testDBContext.xml")
public class UserDAOTest extends BaseDAOTest {

	@Autowired
	public UserService userService;

	@Test
	public void testSave() {
		User user = getMockUser();
		String name = user.getName();
		String surname = user.getSurname();
		userService.saveOrUpdateUser(user);

		List<User> users = userService.findByName(name);
		assertNotNull("User cannot be null !!", users);
		assertEquals("Users list size must be 1 !!", 1, users.size());
		assertEquals("Surname must be equal to" + surname, surname, users.get(0).getSurname());
	}
	
	@Test
	public void testDelete(){
		User user = getMockUser();
		String name = user.getName();
		userService.saveOrUpdateUser(user);
		userService.deleteUser(user);

		List<User> users = userService.findByName(name);
		int size = users == null || users.isEmpty() ? 0 : users.size();
		assertEquals("Users list must be empty !!",0, size);
	}
	
	private User getMockUser(){
		User user = new User();
		user.setName("testName");
		user.setSurname("testSurname");
		return user;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
