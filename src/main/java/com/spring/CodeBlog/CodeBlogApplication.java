package com.spring.CodeBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com/spring/CodeBlog/model")
public class CodeBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeBlogApplication.class, args);
	}

}
