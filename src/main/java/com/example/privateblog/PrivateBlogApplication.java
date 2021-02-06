package com.example.privateblog;

import com.example.privateblog.entity.Article;
import com.example.privateblog.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrivateBlogApplication {

	private static final Logger log = LoggerFactory.getLogger(PrivateBlogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PrivateBlogApplication.class, args);
	}


}
