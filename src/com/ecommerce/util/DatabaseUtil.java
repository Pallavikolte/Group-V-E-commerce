package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseUtil {

	public Connection getConnection() throws Exception {
		try {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/miniproject?characterEncoding=utf8";
		Connection connection=DriverManager.getConnection(url, "root", "ishanvi");
		return connection;
		
	} catch (Exception e) {
		System.out.println("Something went wrong"+ e);
	
	
		return null;}}}
