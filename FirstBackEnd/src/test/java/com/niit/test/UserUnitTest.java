package com.niit.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserUnitTest 
{
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUserId(1);
		user.setUserName("barani");
		user.setUseremailid("ecebarani345@gmail.com");
		user.setUserpassword("barani");
		user.setUserphonenumber("9600786907");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void getUserTest()
	{
		assertNotNull("Problem in get User",userDAO.getUser(2));
	}
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		User user=userDAO.getUser(1);
		assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
	}

	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(1);
		user.setUserName("admin");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	@Test
	public void listUserTest()
	{
		List<User> listUser=userDAO.getUsers();
		assertNotNull("No User",listUser);
		
		for(User user:listUser)
		{
			System.out.print(user.getUserId()+":::");
			System.out.print(user.getUserName()+":::");
			System.out.println(user.getUserpassword()+":::");
		}
	}
}