<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>
<!-- Manda al ControladorLogin.java el contenido en POST -->
<form action="doNuevoUsuario" method="post">
<h1>CREANDO NUEVO USUARIO</h1>
	<label>Usuario<input type="text" name="usuario"></label><br>
	<label>Contraseña<input type="text" name="contrasenia"></label>
	<input type="submit" value="Entrar">
</form>
</body>
</html>