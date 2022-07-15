/**
 * This file contains the method calls that call the service methods,
 * which are performed when a request to the api is executed from the frontend.
 * */

package com.technicalTestBackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalTestBackend.entity.Task;
import com.technicalTestBackend.service.TaskService;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	//Create a new Task
	//param: Task task
	@PostMapping("/tasks")
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}
	
	//Get all the tasks
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return taskService.getTasks();
	}
	//Get task by id
	//param: int id
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable int id) {
		Task task = taskService.getTaskById(id);
		return ResponseEntity.ok(task);
	}
	
	//Update Task
	//param1: int id
	//param2: Task task
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
		
		Task updatedTask = taskService.updateTask(id, task);
		return ResponseEntity.ok(updatedTask);
	}
	
	//Delete Task
	//param: int id
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteTask(@PathVariable int id) {
		Map<String, Boolean> deletedTaskResponse = taskService.deleteTask(id);
		return ResponseEntity.ok(deletedTaskResponse);
	}
}
