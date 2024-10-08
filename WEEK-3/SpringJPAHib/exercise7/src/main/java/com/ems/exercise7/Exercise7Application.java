package com.ems.exercise7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Exercise7Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise7Application.class, args);
	}

}
