package com.taskmanager.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.taskmanager.entities.Task;
import com.taskmanager.taskmanager.entities.User;

public interface TaskRepository extends JpaRepository<Task,Long>{
	
	List<Task> findByUser(User user);
	
	List<Task> findByUserAndCompleted(User user, boolean completed);
	
	List<Task> findByUserAndPriority(User user , Task.Priority priority);

}
