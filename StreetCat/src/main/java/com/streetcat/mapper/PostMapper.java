package com.streetcat.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.streetcat.domain.PostDto;

@Mapper
public interface PostMapper {

	void insertPost(PostDto postDto);

}
