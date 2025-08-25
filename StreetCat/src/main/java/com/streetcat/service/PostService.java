package com.streetcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.streetcat.domain.PostDto;
import com.streetcat.mapper.LoginMapper;
import com.streetcat.mapper.PostMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostService {
	
	private final PostMapper postmapper;
	
	private final LoginMapper loginmapper;
	
	@Autowired
	public PostService(PostMapper postmapper, LoginMapper loginmapper) {
        this.postmapper = postmapper;
        this.loginmapper = loginmapper;
    }

	public void newposting(PostDto postDto) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		UserDetails userDetails = (UserDetails)principal; 
		
		String username = userDetails.getUsername(); 
		
		log.info("username : "+username);
		
		int id = loginmapper.selectId(username);
		
		postDto.setUser_id(id);
		
		postmapper.insertPost(postDto);
	}
	
	public List<PostDto> selectAll() {
		List<PostDto> list = postmapper.selectAll();
		
		for(int i=0; i < list.size(); i++) {
			int id = list.get(i).getUser_id();
			String username = loginmapper.selectUsername(id);
			
			System.out.println(username);
			
			list.get(i).setWriter(username);
			
		}
		
		return list;
	}

	public PostDto selectDetail(int board_id) {
		PostDto dto = postmapper.selectDetail(board_id);
		
		String username = loginmapper.selectUsername(dto.getUser_id());
		dto.setWriter(username);
		
		return dto;
	}

}
