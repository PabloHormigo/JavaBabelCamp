<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modificar un videojuego</h1>
	<h2>${v.nombre}</h2>
	<form action="setModificacionVideojuego" method="get">
		Id: <input type="text" name="videogameId" value="${v.id}" readonly><br>
		Nombre: <input type="text" name="videogameName"><br>
		Compañia: <input type="text" name="videogameCompany"><br>
		Nota media: <input type="text" name="videogameNote"><br>
		Creador: <input type="text" name="videogameCreator"><br>
		Precio: <input type="text" name="videogamePrice"><br>
		Enlace: <input type="text" name="videogameLink"><br>
		<input type="submit" value="Pulsame">
	</form>
</body>
</html>