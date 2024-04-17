<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:darkseagreen;">
	<h2>Online Voting System</h2>
	<hr>
	<form action="afterregister">
		<input type="text" name="name" placeholder="Enter name">
		<input type="text" name="mobile" placeholder="Enter mobile"><br>
		<input type="password" name="password1" placeholder="Enter password" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
		<input type="password" name="password2" placeholder="confirm password"><br>
		<p>Must contain at least one number,uppercase,lowercase,at least 8 characters</p>
		<input type="text" name="address" placeholder="Enter address (optional)">
		<input type="number" name="age" placeholder="Enter age" required>
		<label for="myfile">Select a file</label>
		<input type="file" id="myfile" name="myfile">
		
		<input type="submit" value="Register">
		
	</form>

	<script>
		window.alert("passwords should match");
	</script>
</body>
</html>