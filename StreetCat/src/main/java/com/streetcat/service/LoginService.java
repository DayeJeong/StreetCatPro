package com.streetcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetcat.domain.LoginDto;
import com.streetcat.repository.LoginMapper;

@Service
public class LoginService {
	
	private final LoginMapper loginRepository;

    @Autowired
    public LoginService(LoginMapper loginRepository) {
        this.loginRepository = loginRepository;
    }
	
	public void registerinfo(LoginDto loginDto) {
		
		loginRepository.insertUser(loginDto);
		
	}

	public String usernamecheck(LoginDto loginDto) {
		
		String result = loginRepository.usernamecheck(loginDto);
		
		return result;
	}

}
