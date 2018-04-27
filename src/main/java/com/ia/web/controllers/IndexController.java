package com.ia.web.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index() {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hasSenha = passwordEncoder.encode("1234");

		System.out.println(hasSenha);

		return new ModelAndView("index");
	}

}
