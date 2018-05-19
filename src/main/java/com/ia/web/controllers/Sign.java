package com.ia.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ia.web.models.User;
import com.ia.web.services.UserService;

@Controller
@Transactional
public class Sign {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView singInForm() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public ModelAndView singUpForm() {
		return new ModelAndView("sign-up");
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public @ResponseBody void singUp(@RequestBody User user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		userService.saveUser(user);
		
	}

}