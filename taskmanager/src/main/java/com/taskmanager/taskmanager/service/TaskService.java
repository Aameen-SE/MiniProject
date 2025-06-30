package com.taskmanager.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.entities.Task;
import com.taskmanager.taskmanager.entities.User;
import com.taskmanager.taskmanager.repository.TaskRepository;
import com.taskmanager.taskmanager.repository.UserRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// Method started -----------------------------
	 public String addTask(TaskDto dto) {
	        User user = userRepository.findByUsername(dto.getUsername());
	        if (user == null) {
	        	return "User not found";
	        }

	        Task task = new Task();
	        task.setTitle(dto.getTitle());
	        task.setDescription(dto.getDescription());
	        task.setPriority(Task.Priority.valueOf(dto.getPriority().toUpperCase()));
	        task.setDueDate(dto.getDueDate());
	        task.setCompleted(dto.isCompleted());
	        task.setUser(user);

	        taskRepository.save(task);
	        return "Task added successfully!";
	    }
	/*public String addTask(TaskDto dto) {
		User user = userRepository.findByUsername(dto.getUsername());
		
		if(user==null) {
			return "User not found ";
		}else { 
			Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(Task.Priority.valueOf(dto.getPriority().toUpperCase()));
        task.setDueDate(dto.getDueDate());
        task.setCompleted(dto.isCompleted());
        task.setUser(user);
        
       taskRepository.save(task);
       
	return "Task added successfully!";
	
		}
		
	}
	*/
	
	public List<Task> getTaskByUser(String username){
		User user =userRepository.findByUsername(username);
		return	taskRepository.findByUser(user);
	}
	
	public String deleteTask(Long taskId) {
		if(taskRepository.existsById(taskId)) {
			taskRepository.deleteById(taskId);
			return "Task deleted successfully ";
		}
		return "Task not found ";
	}
	
	
	 public String markTaskComplete(Long taskId) {
	        Optional<Task> optional = taskRepository.findById(taskId);
	        if (optional.isPresent()) {
	            Task task = optional.get();
	            task.setCompleted(true);
	            taskRepository.save(task);
	            return "Task marked as completed.";
	        } else {
	            return "Task not found.";
	        }
	    }
	 
	 
	 public String updateTask(Long taskId, TaskDto dto) {
	        Optional<Task> optional = taskRepository.findById(taskId);
	        if (optional.isPresent()) {
	            Task task = optional.get();
	            task.setTitle(dto.getTitle());
	            task.setDescription(dto.getDescription());
	            task.setDueDate(dto.getDueDate());
	            task.setCompleted(dto.isCompleted());
	            task.setPriority(Task.Priority.valueOf(dto.getPriority().toUpperCase()));
	            taskRepository.save(task);
	            return "Task updated successfully.";
	        } else {
	            return "Task not found.";
	        }
	    }
}
