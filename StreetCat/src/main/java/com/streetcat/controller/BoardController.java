package com.streetcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
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
	
	
}
	