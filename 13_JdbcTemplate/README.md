# JDBC Template

Esta parte de spring esta pensada para que de una manera basica nos ayude a interactuar con una base de datos.
Este motor se apoya en JDBC para hacer las peticiones contra la BBDD.

## Configuracion

A parte de las librerias core de Spring habria que meter la slibrerias de JDBC Template, además debemos de 
meter los drivers de conexion contra la bbdd que usemos.

	<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.framework.version}</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring.framework.version}</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.23</version>
		</dependency>
		
Lo siguiente sería crear la tabla de BBDD, para ello podemos ejecutar la clase es.curso.main.MainCrearTabla.

Aun asi, tenemos que crear el schema de BBDD, que este caso se llamara "jdbcTemplate".