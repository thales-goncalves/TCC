package com.ia.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ia.web.models.User;
import com.ia.web.services.UserService;

@Controller
public class Sign {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String singInForm() {
		return "login";
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String singUpForm() {
		return "sign-up";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public @ResponseBody void singUp(@RequestBody User user) {

		
		System.out.println(user.getLogin());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		userService.saveUser(user);

	}

}