package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserContoller {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public Iterable<User> list() {
		return userService.list();
	}
}
