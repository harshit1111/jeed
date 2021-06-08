package com.tech.blog.helper;

import java.sql.*;

public class ConnectionProvider {
	
	private static Connection conn;
	 
	public static Connection getConnection() {
		
		if(conn == null) {
			
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","run_sql");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return conn;
		
		
	}
	
	

}
