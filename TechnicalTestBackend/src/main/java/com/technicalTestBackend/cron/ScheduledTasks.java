/**
 * This class is in charge of periodically checking 
 * against the database to verify the status of the task
 * and depending on the time that has passed since
 * its creation, change it.
 * */

package com.technicalTestBackend.cron;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class ScheduledTasks {
	
	public ScheduledTasks(){}
	
	@Scheduled(fixedRate = 10000)
	//check every 10 seconds
	public void checkStates() {
		
		try {
			/**
			 * Load mysql driver
			 * setting params for the connection
			 * */
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/technicalTest";
			String user = "root";
			String password = "ro07P@$S";
			
			/**
			 * Connecting to database
			 * and execute query
			 * */
			Connection con = DriverManager.getConnection(url,user,password);
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM technicalTest.task WHERE state != 2");
			
			//iterating results and evaluation
			while(resultSet.next()) {
				
				String ct = resultSet.getString("creation_time");
				int id = resultSet.getInt("id");
				int state = resultSet.getInt("state");
				Statement updateStatement = con.createStatement();

				LocalTime currentTime = LocalTime.now();
				LocalTime time = LocalTime.parse(ct);
				
				int hours =  currentTime.getHour() - time.getHour();
				
				if(currentTime.isBefore(time)) {
					// +24h
					// change directly to state 2
					System.out.println("entra en el caso que la hora actual es antes");
					updateStatement.executeUpdate("UPDATE task SET state = 2 WHERE id='"+id+"'");
				}else {
					System.out.println("entra en el caso que la hora actual es despues");
					if(hours == 0) {
						int minutes =  currentTime.getMinute() - time.getMinute();
						if( state == 0 && minutes > 2 ) {
							updateStatement.executeUpdate("UPDATE task SET state = 1 WHERE id='"+id+"'");
						}
						// 10 minutes = 2 to change to running state + 8 to done state
						if( state == 1 && minutes > 10 ) {
							updateStatement.executeUpdate("UPDATE task SET state = 2 WHERE id='"+id+"'");
						}
					}else {
						//more than 1 hour change directly
						//+2 or +8 minutes change state directly
						if( state == 0 ) {
							updateStatement.executeUpdate("UPDATE task SET state = 1 WHERE id='"+id+"'");
						}
						
						if( state == 1 ) {
							updateStatement.executeUpdate("UPDATE task SET state = 2 WHERE id='"+id+"'");
						}
					}
					
				}
				
				updateStatement.close();
			}
			
			
			resultSet.close();
			statement.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("no se ha podido conectar "+e);
		}
	}
}
