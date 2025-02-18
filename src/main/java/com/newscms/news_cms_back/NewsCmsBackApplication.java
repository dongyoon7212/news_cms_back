package com.newscms.news_cms_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewsCmsBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsCmsBackApplication.class, args);
	}

}
