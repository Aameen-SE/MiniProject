package com.mongoFile.File.Upload.MongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoFile.File.Upload.MongoDb.model.UserFiles;

public interface UserRepository extends MongoRepository<UserFiles, String>{

}
