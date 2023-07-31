package com.SpringWeb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.SpringWeb1.Services.UserService;

@Controller
public class Dispatcher {
	
	@Autowired UserService svc;
	
	@GetMapping("/")
	public String getHomePageHTML() { 
		return "Home.html";
	}
	
	@GetMapping("/users")
	public ModelAndView getUsersPageHTML() { 
		ModelAndView model = new ModelAndView("Users.html");
		model.addObject("first", svc.getById(1l));
		model.addObject("second", svc.getById(2l));
		model.addObject("third", svc.getById(3l));
		model.addObject("fourth", svc.getById(4l));
		model.addObject("fifth", svc.getById(5l));
		return model;
	}
	
	@GetMapping("/users/{id}")
	public ModelAndView getUserInfoHTML(@PathVariable Long id) { 
		ModelAndView model = new ModelAndView("UserInfo.html");
		model.addObject("user", svc.getById(id));
		return model;
	}
}
