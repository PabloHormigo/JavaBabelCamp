<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
    <title>Table Component</title>
    
    <style>
    	* {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      body {
        font-family: 'Inter', sans-serif;
        color: #343a40;
        line-height: 1;
        display: flex;
        justify-content: center;
      }

      table {
        width: 800px;
        border-right-color: #ffffff;
        margin-top: 100px;
        font-size: 18px;
        /* /* border: 1px solid #343a40; */
        border-collapse: collapse; 
      }
      
      th, td {
        /* border: 1px solid #343a40; */
        padding: 16px 24px;
        text-align: left;
      }

      th {
        background-color: #087f5b;
        color: #fff;
        width: 25%;
      }

      tbody tr:nth-child(odd){
        background-color: #f8f9fa;
      }
      
      a {
      	text-decoration: none;
      }

      
      tbody tr:nth-child(even){
        background-color: #e9ecef;
      }
      
      button {
		    display: block;
		    height: 50px;
		    width: 100px;
		    background-color: #5F4785;
		    color: #FFFFFF;
		    font-family: Open Sans;
		    font-weight: 200;
		    font-size: 15px;
		    text-transform: uppercase;
		    border-radius: 3px 3px;
		}
		
		.eliminar {
			background-color: #D61818;
		}
		
		.modificar {
			background-color: #087f5b;
		}
		
	
		.float{
			position:fixed;
			width:60px;
			height:60px;
			bottom:40px;
			right:40px;
			background-color:#0C9;
			color:#FFF;
			border-radius:50px;
			text-align:center;
			box-shadow: 2px 2px 3px #999;
		}
		
		.my-float{
			margin-top:8px;
			font-size: 40px;
		}
    </style>
  </head>
  <body>
  
  	<a href="videojuegos/formVideojuego" class="float">
		<span class="material-icons my-float">
			add
		</span>
	</a>
  
    <table>
    
      <thead>
      
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Compa�ia</th>
          <th>Nota Media</th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
      </thead>

      <tbody>
      
      <c:forEach items="${videojuegos}" var="videojuego">
        <tr>
          <td><c:out value="${videojuego.id}"></c:out></td>
          <td><c:out value="${videojuego.nombre}"></c:out></td>
          <td><c:out value="${videojuego.compania}"></c:out></td>
          <td><c:out value="${videojuego.nota}"></c:out></td>
          <td><a href = "<c:url value="videojuegos/detalle">
                				<c:param name="id" value="${videojuego.id}"/>
         				</c:url>"><button class="detalle">Ver m�s</button></a></td>
         				
         <td><a href = "<c:url value="videojuegos/formVideojuego">
                				<c:param name="id" value="${videojuego.id}"/>
         				</c:url>"><button class="modificar">Modificar</button></a></td>
         				
         <td><a href = "<c:url value="videojuegos/delete">
                				<c:param name="id" value="${videojuego.id}"/>
         				</c:url>"><button class="eliminar">Eliminar</button></a></td>
        </tr>
      </c:forEach> 
        
      </tbody>      
    </table>
  </body>
</html>