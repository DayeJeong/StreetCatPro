package com.streetcat.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.streetcat.domain.LoginDto;
import com.streetcat.security.CustomMemberDetails;

@Mapper
public interface LoginMapper {

	void insertUser(LoginDto loginDto);

	String usernamecheck(LoginDto loginDto);

	CustomMemberDetails membercheck(String email);

	int selectId(String username);

	String selectUsername(int id);

}
