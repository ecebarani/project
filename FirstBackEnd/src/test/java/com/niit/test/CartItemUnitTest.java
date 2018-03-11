package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CartItemDAO;
import com.niit.DAO.CategoryDAO;
import com.niit.model.CartItem;
import com.niit.model.Category;

public class CartItemUnitTest 
{
	static CartItemDAO cartDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		
		context.refresh();
		cartDAO=(CartItemDAO)context.getBean("cartDAO");
	}
          	
	
	@Test
	public void addCartTest()
	{
		
		
		CartItem cartItem=new CartItem();
		cartItem.setCartId(1);
		cartItem.setCartId(1);
		cartItem.setQuantity(1);
		cartItem.setUserName("RAM");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(1);
		assertTrue("Problem in cart Insertion",cartDAO.addCartItem(cartItem));

	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("problem in get category",categoryDAO.getCategory(2));
	}
	
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		 Category category=categoryDAO.getCategory(2);
		assertNotNull("problem in Deleition",categoryDAO.deleteCategory(category));
	}
	

	@Ignore
	@Test
	public void updateCartTest()
	{
		 CartItem cartItem=cartDAO.getCartItem(1);
		 cartItem.setQuantity(2);
		assertNotNull("problem in Updation",cartDAO.updateCartItem(cartItem));
	}
	
	
}
