package com.taskmanager.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.entities.Task;
import com.taskmanager.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addTask(@RequestBody TaskDto dto) {
		String result= taskService.addTask(dto);
		
		if("Username not found".equals(result)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@GetMapping("/{username}")
	public List<Task> getTask(@PathVariable String username){
		return taskService.getTaskByUser(username);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable Long taskId) {
		
		return taskService.deleteTask(taskId);
	}
	
	 @PutMapping("/complete/{taskId}")
	    public String markComplete(@PathVariable Long taskId) {
	        return taskService.markTaskComplete(taskId);
	    }
	 
	 public String updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDTO) {
	        return taskService.updateTask(taskId, taskDTO);
	    }
}
