package com.technicalTestBackend.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;


@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="creationTime")
	private LocalTime creationTime;
	@Column(name="state")
	private TaskStates state;
	
	
	
	public Task(String name,LocalTime time, TaskStates state) {
		super();
		this.name = name;
		this.creationTime = time;
		this.state = state;
	}

	public Task() {
		super();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalTime getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}


	public TaskStates getState() {
		return state;
	}


	public void setState(TaskStates state) {
		this.state = state;
	}
	
	
}
