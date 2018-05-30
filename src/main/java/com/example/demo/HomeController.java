package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	@RequestMapping("/")
	public ModelAndView search() {
		
		return new ModelAndView("index.html");
	}
	@RequestMapping("/1")
	public ModelAndView index() {
		
		return new ModelAndView("search.html");
	}

}
