package com.legitboss.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test_JDBC_Connection {

	public static void main(String[] args) {
		String hostName = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userName = "hbstudent";
		String password = "hbstudent";
		System.out.println("Testing Connection...");
		try{
			Connection conn = DriverManager.getConnection(hostName, userName, password);
			System.out.println("***Connected Successfully***");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
