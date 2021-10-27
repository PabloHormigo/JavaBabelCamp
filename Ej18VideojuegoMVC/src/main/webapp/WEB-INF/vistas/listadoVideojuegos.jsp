<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Videojuegos</title>
</head>
<body>
	<h1>Listado de Videojuegos</h1>
	<h2>${lista}</h2>
	<form action="detalleVideojuego" method="post">
		Id: <input type="number" name="id">
		<input type="submit" value="Pulsame">
	</form>
	<h2 style="color: red">${mensajeError}</h2>
</body>
</html>