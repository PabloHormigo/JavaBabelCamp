<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dar de alta un nuevo videojuego</h1>
	<form action="crearVideojuego" method="get">
		Nombre: <input type="text" name="videogameName"><br>
		Compañia: <input type="text" name="videogameCompany"><br>
		Nota media: <input type="text" name="videogameNote"><br>
		Creador: <input type="text" name="videogameCreator"><br>
		Enlace: <input type="text" name="videogameLink"><br>
		<input type="submit" value="Pulsame">
	</form>
</body>
</html>