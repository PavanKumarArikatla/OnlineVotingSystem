<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form action="adminlogin" method="post">
		<input type="text" name="admin" placeholder="Enter admin id"><br>
		<input type="password" name="adminpassword" placeholder="Enter admin password">
		<input type="submit" value="Login">
		<p style="color:tomato;">Invalid Credentials</p>
	</form>
	

</body>
</html>