package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constants.AppConstants;

@SpringBootApplication
@RestController
public class Application {
	@RequestMapping(AppConstants.HEALTH_CHECK)
	public String home() {
		return AppConstants.IM_ALIVE;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
