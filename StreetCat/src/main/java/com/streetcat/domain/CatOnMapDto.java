package com.streetcat.domain;

import lombok.Data;

@Data
public class CatOnMapDto {
	private int id;
	private double latitude;
    private double longitude;
    private String description;

}
