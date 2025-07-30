package com.streetcat.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	private String username;
	private String password;
	private String name;
	private String email;
	private String address;
	private String phonenumber;
}
