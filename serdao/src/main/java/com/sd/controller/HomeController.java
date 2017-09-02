package com.sd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	@RequestMapping("/")
	public String displaynavbar(){
		return "homepage";
	}
	@RequestMapping("/reqHomePage")
	public String displayhomepage(){
		return "homepage";
		
	}
}
	
	
	