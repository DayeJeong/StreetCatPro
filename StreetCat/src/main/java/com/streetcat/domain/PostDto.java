package com.streetcat.domain;

import lombok.Data;

@Data
public class PostDto {
	private int user_id;
	private int board_id;
	private String title;
	private String content;
	private String writer;
	private String created_time;
	private String updated_time;
	private String region;

}
