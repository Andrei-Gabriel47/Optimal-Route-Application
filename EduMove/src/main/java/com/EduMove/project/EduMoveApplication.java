package com.EduMove.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EduMoveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduMoveApplication.class, args);

	}

}
