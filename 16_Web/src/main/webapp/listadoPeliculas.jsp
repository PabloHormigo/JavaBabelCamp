<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		Un JSP es un servlet, es decir, tomcat convertira el HTML que pongamos
		aqui en un Sevlet preparado para recibir peticiones HTTP y que convertira
		la respuesta en el HTML que contenga
	 -->
	 <h1>Listado de Peliculas</h1>
	 
	 <!-- Podemos acceder a los atributos que nos pasa el controlador mediante
	 la siguiente sentencia -->
	 <h2>${lista}</h2>
</body>
</html>