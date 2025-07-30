package com.streetcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping("/logon")
	public String logOn(){
		return "login/Logon";
	}
	
	@PostMapping("logoninfo")
	public String logoninfo(Model model, LoginDto loginDto) {
		
		model.addAttribute(loginDto);
		
		service.logoninfo(loginDto);
		
		return "";
	}
}
