<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Voting System - Admin Page</title>
</head>
<body>

	<form action="adminfunctions" method="post">
		<input type="submit" name="submit" value="GetVoters">
		<input type="submit" name="submit" value="Voted">
		<input type="submit" name="submit" value="UnVoted"><br><br>
		<input type="text" name="name" placeholder="Enter name to delete">
		<input type="submit" name="submit" value="Remove Voter">
	</form>

</body>
</html>