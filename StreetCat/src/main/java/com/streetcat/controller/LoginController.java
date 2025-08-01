package com.streetcat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.streetcat.domain.LoginDto;
import com.streetcat.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	//페이지이동
	@GetMapping("/login")
	public String toLog(){
		return "login/Login";	// templates/login/Login.html
	}
	
	//회원가입페이지 구현
	@GetMapping("/register")
	public String register(){
		System.out.println("--------------------");
		return "login/register";
	}
	
	@PostMapping("/registerinfo")
	public String registerinfo(LoginDto loginDto) {
		
		System.out.println(loginDto);
		
		service.registerinfo(loginDto);
		
		return "redirect:/login";
		
	}
}
