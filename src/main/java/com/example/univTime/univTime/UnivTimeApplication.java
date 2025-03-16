package com.example.univTime.univTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UnivTimeApplication {
	public static void main(String[] args) {
		SpringApplication.run(UnivTimeApplication.class, args);
	}
}
