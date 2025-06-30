package com.taskmanager.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.dto.UserDto;
import com.taskmanager.taskmanager.entities.User;
import com.taskmanager.taskmanager.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository userRepository;
	
	public String register(UserDto userDto) {
		
		if(userRepository.findByUsername(userDto.getUsername())!=null) {
			return "Username already exists.";
		}
		
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		
		userRepository.save(user);
		return "User Registered Succesfully";
	}
	
	public String login(UserDto userDto) {
		User user = userRepository.findByUsername(userDto.getUsername());
		if(user!=null&& user.getPassword().equals(userDto.getPassword())) {
			return "Login Succesful";
		}
		
		return "Invalid username or password";
	}
	
}
