<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del Videojuego</title>
</head>
<body>
	<h1>${v.nombre}</h1>
	<p>Id: ${v.id}</p>
	<p>Compañia: ${v.compania}</p>
	<p>Nota media: ${v.notaMedia}</p>
	<p>Creador: ${v.creador}</p>
	<a href="${v.enlace}">Comprar el juego</a>
</body>
</html>