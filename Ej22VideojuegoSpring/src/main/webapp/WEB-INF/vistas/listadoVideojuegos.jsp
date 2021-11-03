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
	<h2>Cliente: ${userName}</h2>
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
	<form action="anadirCarrito" method="get">
		Comprar Videojuego: <input type="number" name="idAnadir">
		<input type="submit" value="Anadir al carrito">
	</form>
	<br>
	<p>Carrito: ${listaCarrito}</p>
	<h2>Total a pagar: ${totalPagar} euros</h2>
	<a href="volverLogin">Desconectar</a>
	<h2></h2>
	<h2 style="color: red">${mensajeError}</h2>
</body>
</html>