# Spring Boot con Spring MVC y Spring JPA Data

## Creacion del proyecto con Spring Boot

Para crear este proyecto debemos de crear un proyecto spring boot normal y añadir tres starter, uno seria el de Spring JPA data, otro seria Spring Web y el otro sería la base de datos H2.

No hace falta configurar un Tomcat en nuestro proyecto, ni siquiera descargarlo, Spring Boot incluira un servidor Tomcat en nuestro ejecutable.

Hay varios motores de plantillas en una aplicacion Spring Boot (Thymeleaf o JSP, los más famosos). Thymeleaf viene incluido por defecto en spring boot pero JSP no, por lo que debemos de incluirlo en el pom.xml de nuestro proyecto maven.

	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	</dependency>
	
Los recursos estaticos (HTML, CSS, JS, etc) van dentro de "src/main"resources/static"

Al estar tomcat embebido en nuestra aplicacion todos los recursos estaran disponibles desde "http://localhost:8080/"

Si por ejemplo creamos un HTML llamado index.html, para acceder a el deberiamos poner "http://localhost:8080/index.html"

## Fichero de configuracion de Spring boot

Podemos configurar nuestro puerto en el fichero de configuracion application.properties

## Poner en marcha la aplicacion

Para arrancar una aplicacion Spring Boot debemos ejecutar el método main de la misma. 


## Bibliografia:

