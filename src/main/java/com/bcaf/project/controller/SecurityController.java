package com.bcaf.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@GetMapping(value="/login")
	private String login() {
		return "security/login";
	}

}
