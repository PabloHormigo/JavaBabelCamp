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
	<form action="detalleVideojuego" method="get">
		Id: <input type="number" name="id">
		<input type="submit" value="Detalles">
	</form>
	<br>
	<form action="eliminarVideojuego" method="get">
		Id a Eliminar: <input type="number" name="idEliminar">
		<input type="submit" value="Eliminar Videojuego">
	</form>
	<br>
	<form action="modificarVideojuego" method="get">
		Id a Modificar: <input type="number" name="idModificar">
		<input type="submit" value="Modificar Videojuego">
	</form>
	<br>
	<form action="nuevoVideojuego" method="get">
		<input type="submit" value="Crear Videojuego">
	</form>
	<br>
	<h2 style="color: red">${mensajeError}</h2>
</body>
</html>