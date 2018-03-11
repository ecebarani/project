package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 

{
	@RequestMapping("/HOME")
	public String showHome()
	{
		return "Home";
	}
	@RequestMapping("/")
	public String showHomePage()
	{
		return "index";
	}
	@RequestMapping("/ContactUs")
	public String showContactUs()
	{
		return "ContactUs";
	}
	@RequestMapping("/AboutUs")
	public String showAboutUs()
	{
		return "AboutUs";
	}

	@RequestMapping("/Register")
	public String showRegister()
	{
		return "Register";
	}
	@RequestMapping("/Login")
	public String showLogin()
	{
		return "Login";
	}
	
}