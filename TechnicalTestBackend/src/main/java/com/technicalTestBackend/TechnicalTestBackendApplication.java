package com.technicalTestBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.technicalTestBackend.cron.ScheduledTasks;

@SpringBootApplication
@EnableScheduling
public class TechnicalTestBackendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TechnicalTestBackendApplication.class, args);
		ScheduledTasks scheduledTask = new ScheduledTasks();
		scheduledTask.checkStates();
	}

}
