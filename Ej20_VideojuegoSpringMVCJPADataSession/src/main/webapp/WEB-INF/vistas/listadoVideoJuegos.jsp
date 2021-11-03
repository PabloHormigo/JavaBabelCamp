<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de Videojuegos</h1>
	<h2>${lista}</h2>
	
	<form action="detalleJuego" method="post">
		<label>Id Videojuego<input type="number" name="id"></label><br>
		<input type="submit" value="Buscar">
	</form>
	<form action="altaJuego" method="post">
		<input type="submit" value="Nuevo Juego">
	</form>
	<form action="modificarJuego" method="post">
		<input type="submit" value="Modificar Juego">
	</form>
	<form action="bajaJuego" method="post">
		<input type="submit" value="Eliminar Juego">
	</form>
</body>
</html>