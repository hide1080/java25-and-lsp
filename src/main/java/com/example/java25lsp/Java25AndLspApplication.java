package com.example.java25lsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Java25AndLspApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java25AndLspApplication.class, args);
	}

	@GetMapping("/hello")
	public String getDemo() {
		return "Hello from Spring Boot on WSL2!";
	}
}