package com.niit.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/UserHome")
	public String displayUserHome(Model m)
	{	
		List<Product>getProducts=productDAO.getProducts();
		m.addAttribute("listProducts",getProducts);
		boolean loggedIn=false;	
		return "UserHome";
	}
	
	@RequestMapping(value="/Register",method=RequestMethod.POST)
	public String ShowRegisterPage(@RequestParam("userName")String userName,@RequestParam("userpassword")String userPassword,
			@RequestParam("userAddress")String userAddress,@RequestParam("userEmailId")String userEmailId,
			@RequestParam("mobileno")String mobileno)
	{
		User user=new User();
		user.setUserpassword(userPassword);
		user.setUserName(userName);
		user.setUserAddress(userAddress);
		user.setUseremailid(userEmailId);
		user.setUserphonenumber(mobileno);
		
		userDAO.addUser(user);
		 return "LogIn";
	}
	@RequestMapping("/login_Success")
	public String ShowHomePage(HttpSession session,Model m)
	{
		
		String page="";
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		String userName=authentication.getName();
		
		Collection<GrantedAuthority>roles=(Collection<GrantedAuthority>)
				authentication.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("userName",userName);
			}
		}
		return page;
		
	}
	}