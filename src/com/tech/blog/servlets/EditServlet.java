package com.tech.blog.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.entity.*;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.dao.*;;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession s = request.getSession();
		
		User user = (User)s.getAttribute("currentUser");
		
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		
		boolean done = dao.updateUser(user);
		
		PrintWriter out = response.getWriter();
		
		if(done) {
			s.removeAttribute("currentUser");
			out.println("Updated sucessfullt");
		}else {
			out.println("Something went wrong");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
