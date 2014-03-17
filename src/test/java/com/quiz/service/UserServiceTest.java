package com.quiz.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quiz.dao.UserDAO;
import com.quiz.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testDBContext.xml")
public class UserServiceTest {
	
	@Mock
	private UserDAO userDAOMock;
	
	@InjectMocks
	@Autowired
	private UserService userService;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void testSaveOrUpdateForNotNullUserObject(){
        when(userDAOMock.saveOrUpdate(any(User.class))).thenReturn(true);
        Assert.assertNotNull(userService);
        User user = new User();
        boolean success = userService.saveOrUpdateUser(user);
        Assert.assertEquals(true,success);
    }
	
	@Test
    public void testSaveOrUpdateForNullUserObject(){
        when(userDAOMock.saveOrUpdate(any(User.class))).thenReturn(true);
        Assert.assertNotNull(userService);
        User user = null;
        boolean success = userService.saveOrUpdateUser(user);
        Assert.assertEquals(false,success);
    }
	
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
