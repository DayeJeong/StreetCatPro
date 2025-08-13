package com.streetcat.domain;

import lombok.Data;

@Data
public class PostDto {
	private String title;
	private String content;
	private String created_time;
	private String updated_time;
	private String region;

}
