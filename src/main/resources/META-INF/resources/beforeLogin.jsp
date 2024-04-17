<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Voting System - Login</title>
</head>
<body style="background-color: darkseagreen">
	<div>Online Voting System</div>
	<hr>
	<div>
		<h3>Login</h3>
		<form action="voterdao" method="post">
			<input type="text" name="name"><br>
			<input type="password" name="password"><br>
			<input type="submit" value="Login"><br>
		</form>
		<form action="toregister">
		<p>New user?<input type="submit" value="Register"></p>
		</form>
		
		<form action="adminservlet" method="post">
			<input type="submit" value="Admin Login">
		</form>
	</div>
	
</body>
</html>