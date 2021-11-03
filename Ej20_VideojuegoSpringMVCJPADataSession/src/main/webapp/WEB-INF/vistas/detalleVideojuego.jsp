<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${v.nombre}</title>
</head>
<body>
	<h2>${v.id}</h2>
	<h2>${v.nombre}</h2>
	<h2>${v.notaMedia}</h2>
	<h2>${v.creador}</h2>
	<a href="${v.link}">${v.link}</a>
</body>
</html>