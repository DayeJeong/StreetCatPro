package com.streetcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//페이지이동
	@GetMapping("/login")
	public String toLog(){
		return "/Login";
	}
	
}
