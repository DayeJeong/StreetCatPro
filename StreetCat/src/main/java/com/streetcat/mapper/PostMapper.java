package com.streetcat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.streetcat.domain.PostDto;

@Mapper
public interface PostMapper {

	void insertPost(PostDto postDto);

	List<PostDto> selectAll();

	PostDto selectDetail(int board_id);

	void updatePost(PostDto postDto);

}
