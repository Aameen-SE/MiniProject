package com.mongoFile.File.Upload.MongoDb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongoFile.File.Upload.MongoDb.dto.UserFileDto;
import com.mongoFile.File.Upload.MongoDb.model.UserFiles;
import com.mongoFile.File.Upload.MongoDb.repository.UserRepository;

@RestController
@RequestMapping("/files")
public class UserFilesController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException{
		UserFiles files = new UserFiles();
		files.setFileName(file.getOriginalFilename());
		files.setContentType(file.getContentType());
		files.setData(file.getBytes());
		
		userRepository.save(files);
		return ResponseEntity.ok("File uploaded successfully");
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable String id){
		Optional<UserFiles> files = userRepository.findById(id);
		if(!files.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		UserFiles userFile = files.get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(userFile.getContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; file name=\""+userFile.getFileName()+"\"")
				.body(userFile.getData());
		
	}
	
	@GetMapping("/all")
	public List<UserFileDto> getAllFiles(){
		return userRepository.findAll().stream()
				.map(file -> new UserFileDto(file.getId(), file.getFileName(), file.getContentType()))
				.toList();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id){
		if(!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		userRepository.deleteById(id);
		return ResponseEntity.ok("Deleted Succesfully");
	} 
	
	
	
}
