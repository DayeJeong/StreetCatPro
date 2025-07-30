package com.streetcat.service;

import org.springframework.stereotype.Service;

import com.streetcat.domain.LoginDto;
import com.streetcat.repository.LoginMapper;

@Service
public class LoginService {

	private static LoginMapper loginRepository;
	
	public void logoninfo(LoginDto loginDto) {
		
		loginRepository.insertUser(loginDto);
		
	}

}
