package com.taskmanager.taskmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	   @Column(unique = true, nullable = false)
	    private String username;

	    @Column(nullable = false)
	    private String password;
	
	    public void setUsername(String username) {
	    	this.username=username;
	    }
	    
	    public String getUsername() {
	    	return username;
	    }
	    
	    public void setPassword(String password) {
	    	this.password=password;
	    }
	    
	    public String getPassword() {
	    	return password;
	    }

}
