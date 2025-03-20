<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Test</title>
</head>
<body>
    <h2>Hello, JSP in Spring Boot!</h2>
	
	<form action="addAlien" method="post">
		Enter your id : <input type="text" name="aid"><br>
		Enter your name : <input type="text" name="aname"><br>
		<input type="submit">
		
		</form>
		<hr>
		<form action="getAlien" method="get">
			Enter your id : <input type="text" name="aid"/><br/>
			<input type="submit"/>
			
		</form>
		<hr>
				<form action="getAlienByName" method="get">
					Enter your name : <input type="text" name="aname"/><br/>
					<input type="submit"/>
					
				</form>
</body>
</html>
