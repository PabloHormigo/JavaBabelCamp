<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dar de alta un nuevo usuario</h1>
	<form action="crearUsuario" method="get">
		Nombre: <input type="text" name="userNamer">
		Password: <input type="password" name="userPwd">
		<input type="submit" value="Pulsame">
	</form>
</body>
</html>