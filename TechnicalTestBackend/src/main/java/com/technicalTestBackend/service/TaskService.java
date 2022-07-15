/**
 * This file contains the methods that implement the read,
 * write, update and delete actions against the database task table
 * and one to find a task by id.
 * */

package com.technicalTestBackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalTestBackend.entity.Task;
import com.technicalTestBackend.exception.ResourceNotFoundException;
import com.technicalTestBackend.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	//Method to post a task
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	//Method to retrieve all the tasks
	public List<Task> getTasks(){
		return taskRepository.findAll();
	}
	
	//Method to retrieve a task by id
	//param: int id
	public Task getTaskById(int id) {
		Task task = taskRepository.findById(id).orElseThrow(
												()->new ResourceNotFoundException("The task with id: "+ id +" do not exists."));
		return task;
	}	
	
	//Method to update a single task
	//param1: int id
	//param2: Task task
	public Task updateTask(int id, Task task) {
		Task taskToUpdate =  taskRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("The task with id: "+ id +" do not exists."));
		
		taskToUpdate.setName(task.getName());
		taskToUpdate.setState(task.getState());
		taskToUpdate.setCreationTime(task.getCreationTime());
		
		Task updatedTask = taskRepository.save(taskToUpdate);
		
		return updatedTask;
	}
	
	//Method to delete a task
	//para: int id
	public  Map<String, Boolean> deleteTask(int id) {
		Task task = taskRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("The task with id: "+ id +" do not exists."));
	
		taskRepository.delete(task);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
