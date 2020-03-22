package com.userfront;

import com.userfront.brouillon.Triangle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserFrontApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UserFrontApplication.class, args);
        new Triangle().draw();
	}
}
