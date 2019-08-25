package com.bcaf.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {
	
	@RequestMapping(value="/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin";
        }
		else if (request.isUserInRole("USER")) {
			return "redirect:/home/";
		}
		else if (request.isUserInRole("ADMIN")) {
			return "redirect:/home/";
		}          
		else if (request.isUserInRole("HEAD")) {
			return "redirect:/head/";
		}
		else if (request.isUserInRole("TEAMLEADER")) {
			return "redirect:/head";
		}                                   
		return "redirect:/home/";
	}
	
	@RequestMapping(value="/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/home/index");
		return view;
		
	}
	
	@RequestMapping(value="/home")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("/home/index");
		return view;
		
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView admin() {
		ModelAndView view = new ModelAndView("/home/admin");
		return view;
		
	}
	
	@RequestMapping(value="/head")
	public ModelAndView head() {
		ModelAndView view = new ModelAndView("/home/head");
		return view;
		
	}
	
}
