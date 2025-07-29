package com.mongo.api.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mongo.api.demo.entity.User;
import com.mongo.api.demo.repository.UserRepository;

@Service
public class UserServices {
	
	private UserRepository repo;
	
	public UserServices(UserRepository repo) {
		this.repo=repo;
	}
	
	public List<User> getAll(){
		return repo.findAll();
	}
	
	public User addUser(User user) {
		return repo.save(user);
	}

	public User getUserById(String id) {
		return repo.findById(id).orElseThrow();
	}
}
