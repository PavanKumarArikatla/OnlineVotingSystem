<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Voting System</title>
<style>
	*{box-sizing:border-box;}
</style>
</head>
<body style="background-color:darkseagreen; font-size:2vw">
	
	<h3>Online Voting System</h3>
	<hr>
	<% String imagefile = (String)session.getAttribute("imagefile"); %>
	
	<img src="Vizag1.JPG" alt="image" >
	<div>
		Name	: ${name } <br>
		Age		: ${age }<br>
		Mobile	: ${mobile }<br>
	</div>
		
		
			<form action="votestatus">
				<nav>
					<h3>Party 1</h3>
					<input type="submit" value="Vote">
				</nav>
				<article>
					<img src="https://t4.ftcdn.net/jpg/05/17/87/17/360_F_517871765_XxFbBbKrbHl8ibmM3dcew0M5d8CLlRZN.jpg" alt="Symbol" width="200" height="120" >
				</article>
			</form>
	
			<form action="votestatus">
				<nav>
					<h3>Party 2</h3>
					<input type="submit" value="Vote">
				</nav>
				<article>
					<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuKJ-RZMhnjpXOvwQATOMDNOvzO1u4LGFFGCGyK9K1yg&s" alt="Symbol" width="200" height="120" >
				</article>
			</form>
			
			<form action="votestatus">
				<nav>
					<h3>Party 3</h3>
					<input type="submit" value="Vote">
				</nav>
				<article>
					<img src="https://c8.alamy.com/comp/2MEX4XB/hindustan-ambassador-mark-ii-india-1969-called-amby-product-of-hindustan-motors-ltd-of-birlas-4-door-sedan-car-gasoline-engine-of-1498-cc-graceful-and-rich-looks-chrome-bits-in-the-front-that-used-to-flash-in-ambassador-mark-i-are-pulled-o-2MEX4XB.jpg" alt="Symbol" width="200" height="120" >
				</article>
			</form>
			
	
</body>
</html>