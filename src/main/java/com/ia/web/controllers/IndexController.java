package com.ia.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index() {

		return new ModelAndView("index");
	}

}
