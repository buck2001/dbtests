package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.AppConstants;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class }) // gets us over exceptions during boot for MongoDB
@RestController
public class Application extends SpringBootServletInitializer {
	@RequestMapping(AppConstants.HEALTH_CHECK)
	public String home() {
		return AppConstants.IM_ALIVE;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
