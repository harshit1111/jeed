package com.tech.blog.servlets;

import java.io.IOException;
import java.io.*;

import com.tech.blog.entity.*;
import com.tech.blog.dao.*;
import com.tech.blog.helper.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@MultipartConfig
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req);
		
		Map params = req.getParameterMap();
		System.out.println(params);
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		
		PrintWriter  out = resp.getWriter();
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(gender);
		
		if(name == "" || email == "" || password == "" || gender == "") {
			out.println("Not allowed");
			return;
		}
		
		if(name == null || email == null || password == null || gender == null) {
			
		}else {
			User user = new User(name,email,password,gender);
			
			UserDao connection = new UserDao(ConnectionProvider.getConnection());
			if(connection.saveUser(user)) {
				out.println("successfully done");
				resp.sendRedirect("./login.jsp");
			}else {
				out.println("problem");
			}
		}
		
	}

}
