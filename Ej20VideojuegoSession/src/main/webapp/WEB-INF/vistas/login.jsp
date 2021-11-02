<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videojuegos</title>
</head>
<body>
	<h1>Login:</h1>
	<form action="mvc/login" method="post">
		Usuario: <input type="text" name="user">
		Password: <input type="password" name="pwd">
		<input type="submit" value="Login">
	</form>
	<form action="mvc/nuevoUsuario">
		<input type="submit" value="Dar de alta">
	</form>
</body>
</html>