package com.tech.blog.dao;

import java.sql.*;

import javax.servlet.http.HttpSession;

import com.tech.blog.entity.*;
import com.tech.blog.helper.ConnectionProvider;

public class UserDao {
		
	private Connection conn;
	
	public UserDao(Connection c){
		this.conn = c;
	}
	
	public boolean saveUser(User user) {
		
		boolean f = false;
		
		try {
			
			String q = "insert into user(name,email,password,gender) values(?,?,?,?)";
			
			 PreparedStatement pstmt =  this.conn.prepareStatement(q);
			 
			 pstmt.setString(1, user.getName());
			 pstmt.setString(2, user.getEmail());
			 pstmt.setString(3, user.getPassword());
			 pstmt.setString(4, user.getGender());
			 
			 pstmt.executeUpdate();
			 f= true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	public User gerUserByEmail(String email,String password) {
		
		User user = null;
		
		try {
			String q = "select * from user where email=? and password = ?";
			
			PreparedStatement pstmt = this.conn.prepareStatement(q);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet s =  pstmt.executeQuery();
			
			if(s.next()) {
				
				user = new User();
				
				user.setName(s.getString("name"));
				user.setEmail(s.getString("email"));
				user.setPassword(s.getString("password"));
				user.setGender(s.getString("email"));
				user.setId(s.getInt("id"));
				
				return user;
			}
			
			return null;
			
			//System.out.println(s);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
		
		
	}
	
	public boolean updateUser(User user)  {
		boolean f = false;
		
		try {
			
			String q = "update user set name=? , email = ? , password = ? where id = ?";
		
			
			PreparedStatement pstmt = conn.prepareStatement(q);
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getId());
			
			pstmt.executeUpdate();
			
			f = true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

		
		return f;
	}
	
}
