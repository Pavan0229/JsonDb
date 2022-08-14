package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.User;
import com.example.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JsonDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonDbApplication.class, args);

	}

	CommandLineRunner runner(UserService userService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream, typeReference);
				userService.save(users);
				System.out.println("Users Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};

	}

}
