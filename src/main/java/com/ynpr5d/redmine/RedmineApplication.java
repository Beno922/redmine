package com.ynpr5d.redmine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ynpr5d.redmine")
public class RedmineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedmineApplication.class, args);
	}

}
