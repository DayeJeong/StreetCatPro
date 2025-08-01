package com.streetcat.repository;

import org.apache.ibatis.annotations.Mapper;

import com.streetcat.domain.LoginDto;

@Mapper
public interface LoginMapper {

	void insertUser(LoginDto loginDto);

}
