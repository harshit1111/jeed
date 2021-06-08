package com.tech.blog.entity;

import java.sql.*;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private Timestamp dateTime;
	private String gender;
	
	
	public User() {
		
	}
	
	public User(String name, String email, String password ,String gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	
	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
