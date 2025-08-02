package com.mongo.api.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.api.demo.entity.User;
import com.mongo.api.demo.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserServices services;
	
	public UserController(UserServices services) {
		this.services=services;
	}
	
	@GetMapping
	public List<User> getAll(){
		return services.getAll();
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return services.addUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) {
		return services.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable String id) {
		 return services.deleteUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable String id , @RequestBody User user) {
	return services.updateUserByID(id, user);	
	}
}
