package com.streetcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetcat.domain.PostDto;
import com.streetcat.mapper.PostMapper;

@Service
public class PostService {
	
	private final PostMapper postmapper;
	
	@Autowired
	public PostService(PostMapper postmapper) {
        this.postmapper = postmapper;
    }

	public void newposting(PostDto postDto) {
		postmapper.insertPost(postDto);
	}

	
	

}
