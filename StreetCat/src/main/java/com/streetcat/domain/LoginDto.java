package com.streetcat.domain;

import lombok.Data;

@Data
public class LoginDto {
	private String username;
	private String password;
	private String name;
	private String email;
	private String address;
	private String phonenumber;
}
