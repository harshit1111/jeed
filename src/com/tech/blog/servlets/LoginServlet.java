package com.tech.blog.servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.dao.*;
import com.tech.blog.entity.*;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		
		User u =  dao.gerUserByEmail(email, password);
		
		if(u == null) {
			out.println("Invalid details");
		}else {
			
			HttpSession s = req.getSession();
			
			s.setAttribute("currentUser", u);
			resp.sendRedirect("profile.jsp");
			
		}
		
	}
	
	

}
