package com.streetcat.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.streetcat.domain.LoginDto;
import com.streetcat.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로그찍기
@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	//로그인페이지
	@GetMapping("/login/login")
	public String toLog(){
		return "login/Login";	// templates/login/Login.html
	}
	
	// 실패시 리다이렉트
	@GetMapping("/login")
    public String loginRootRedirect() {
        return "redirect:/login/login";
    }
	
	
	//회원가입페이지 구현
	@GetMapping("/login/register")
	public String register(){
		return "login/register";
	}
	
	@PostMapping("/login/registerinfo")
	public String registerinfo(LoginDto loginDto) {
		
		log.info("loginDto: {}",loginDto);
		
		service.registerinfo(loginDto);
		
		return "redirect:/login";
		
	}
	
	@GetMapping("/register/usernamecheck")
	@ResponseBody
	public Map<String, Boolean> usernamecheck(LoginDto loginDto) {
		
		log.info("username: {}", loginDto.getUsername());
		
		String check = service.usernamecheck(loginDto);
		
		log.info("check: {}", check);
		
		boolean isAvailable = (check == null || check.isEmpty());
		
		Map<String, Boolean> result = new HashMap<>();
	    result.put("isAvailable", isAvailable);

	    log.info("result: {}",result);
	    
		return result;
	}
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
}
