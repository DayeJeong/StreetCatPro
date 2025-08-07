package com.streetcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	public void registerinfo(LoginDto loginDto) {
		
		loginDto.setPassword(passwordEncoder.encode(loginDto.getPassword()));
		
		loginRepository.insertUser(loginDto);
		
	}

	public String usernamecheck(LoginDto loginDto) {
		
		String result = loginRepository.usernamecheck(loginDto);
		
		return result;
	}

}
