package com.streetcat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.streetcat.domain.PostDto;
import com.streetcat.service.PostService;

@Controller
public class BoardController {
	
	@Autowired
	PostService postService;
	
	//게시판
	@GetMapping("/board/board")
	public String boardMain(Model model) {
		//게시물 리스트 받아오기
		List<PostDto> list = postService.selectAll();
		model.addAttribute("posts", list);
		
		return "board/Board";
	}
	
	//해당게시글로 이동
	@GetMapping("/board/{board_id}")
	public String boardDetail(@PathVariable("board_id") int board_id, Model model) {
		PostDto dto = postService.selectDetail(board_id);
		model.addAttribute("detail", dto);
		System.out.println("뭐가나오니? ----- "+dto);
		
		return "board/PostDetail";
	}
	
	//글쓰기
	@GetMapping("/board/write")
	public String writePost() {
		return "board/PostForm";
	}
	
	//게시글 저장
	@PostMapping("/board/newPost")
	public String newposting(PostDto postDto) {
		postService.newposting(postDto);
		return "redirect:/board/board";
	}
	/*
	 * //자유게시판
	 * 
	 * @GetMapping("/board/free") public String freeBoard() { return "board/ }
	 */
	
}
	