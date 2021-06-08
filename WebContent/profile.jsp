<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="com.tech.blog.entity.*" %>
<%@ page errorPage="error.jsp" %>    

<%@ page import="com.tech.blog.entity.*" %>

<% 

	User user = (User)session.getAttribute("currentUser");

%>
  
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link href="./css/index.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%@include file="navbar.jsp" %>
		
		<div class="container">
		
			<div class="row" id="display">
				<div class="col-4 offset-4">
					<div class="card mt-5">
						<div class="card-head p-4">
							<h1><%= user.getName() %></h1>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-6">
									<h3>ID</h3>
								</div>
								<div class="col-6">
									<h3><%= user.getId() %></h3>
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<h3>Name</h3>
								</div>
								<div class="col-6">
									<h3><%= user.getName() %></h3>
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<h3>Email</h3>
								</div>
								<div class="col-6">
									<h3><%= user.getEmail() %></h3>
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<h3>Password</h3>
								</div>
								<div class="col-6">
									<h3><%= user.getPassword() %></h3>
								</div>
							</div>
						</div>
						<div class='card-footer'>
							<button class="btn btn-outline-primary" id="change">Edit</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="row" style="display:none" id="edit">
				<div class="col-4 offset-4">
					<div class="card mt-5">
						<div class="card-head p-4">
							<h1><%= user.getName() %></h1>
						</div>
						<form action="EditServlet" method="post">
						
						<div class="card-body">
						
						
							<div class="row">
								<div class="col-6">
									<h3>ID</h3>
								</div>
								<div class="col-6">
									<h3><%= user.getId() %></h3>
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<h3>Name</h3>
								</div>
								<div class="col-6">
									<input value ="<%= user.getName() %>"  name="name" >
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<h3>Email</h3>
								</div>
								<div class="col-6">
									<input value ="<%= user.getEmail() %>"  name="email" >
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<h3>Password</h3>
								</div>
								<div class="col-6">
									<input value ="<%= user.getPassword() %>"  name="password" >
								</div>
							</div>
						</div>
						<div class='card-footer'>
							<button class="btn btn-outline-primary" id="back">Back</button>
							<button class="btn btn-outline-primary" href="#">Save</button>
						</div>
						</form>
						
					</div>
				</div>
			</div>
			
		</div>
		
		
		<script>
			document.getElementById("change").addEventListener("click",() => {
				document.getElementById("display").style.display = "none";
				document.getElementById("edit").style.display = "block";
			})
			
			document.getElementById("back").addEventListener("click",() => {
				document.getElementById("display").style.display = "block";
				document.getElementById("edit").style.display = "none";
			})
			
			
		</script>
		
	
</body>
</html>