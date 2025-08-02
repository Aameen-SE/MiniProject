package com.mongo.api.demo.services;

import java.util.List;
import java.util.Optional;

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
	
	public String deleteUserById(String id) {
		Optional<User> user = repo.findById(id);
		
					if(user.isPresent()) {
				repo.deleteById(id);
				return "User Deleted Successfully";
			}
					else
					{
						return "User not found ";
					}
				
	}
	
	public User updateUserByID(String id, User updatedUser) {
		Optional<User> optionalUser = repo.findById(id);
		
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setId(updatedUser.getId());
			user.setName(updatedUser.getName());
			user.setEmail(updatedUser.getEmail());
			
			return repo.save(user);
		}
		else
		{
			throw new RuntimeException("User not found with that id");
		}
	}
}
