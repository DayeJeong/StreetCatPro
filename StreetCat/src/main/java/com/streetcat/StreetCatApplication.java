package com.streetcat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streetcat.repository")
public class StreetCatApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreetCatApplication.class, args);
	}

}
