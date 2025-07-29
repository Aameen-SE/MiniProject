package com.mongo.api.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.api.demo.entity.User;

public interface UserRepository extends MongoRepository<User,String> {

}
