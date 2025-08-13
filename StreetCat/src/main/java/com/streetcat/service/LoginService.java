package com.streetcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.streetcat.domain.LoginDto;
import com.streetcat.mapper.LoginMapper;

@Service
public class LoginService {
	
	private final LoginMapper loginmapper;
	
    @Autowired
    public LoginService(LoginMapper loginmapper) {
        this.loginmapper = loginmapper;
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	public void registerinfo(LoginDto loginDto) {
		
		loginDto.setPassword(passwordEncoder.encode(loginDto.getPassword()));
		
		loginmapper.insertUser(loginDto);
		
	}

	public String usernamecheck(LoginDto loginDto) {
		
		String result = loginmapper.usernamecheck(loginDto);
		
		return result;
	}

}
