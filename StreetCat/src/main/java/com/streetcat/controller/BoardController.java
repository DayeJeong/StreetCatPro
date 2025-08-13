package com.streetcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.streetcat.domain.PostDto;
import com.streetcat.service.PostService;

@Controller
public class BoardController {
	
	@Autowired
	PostService postService;
	
	//게시판
	@GetMapping("/board/board")
	public String boardMain() {
		return "board/Board";
	}
	
	//글쓰기
	@GetMapping("/board/write")
	public String writePost() {
		return "board/PostForm";
	}
	
	//게시글 저장
	@PostMapping("/board/newPost")
	public void newposting(PostDto postDto) {
		postService.newposting(postDto);
		
	}
	/*
	 * //자유게시판
	 * 
	 * @GetMapping("/board/free") public String freeBoard() { return "board/ }
	 */
	
}
	