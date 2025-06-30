package com.taskmanager.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.dto.UserDto;
import com.taskmanager.taskmanager.service.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String userRegister(@RequestBody UserDto userDto) {
		
		return userService.register(userDto);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserDto userDto) {
		
		return userService.login(userDto);
	}

}
