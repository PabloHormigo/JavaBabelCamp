package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.config.Configuracion;
import es.curso.modelo.persistencia.DaoClienteJdbcTemplate;
import es.curso.modelo.persistencia.DaoPedidoJdbcTemplate;

public class MainCrearTablas {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		DaoPedidoJdbcTemplate daoP = context.getBean("daoPedidoJdbcTemplate",DaoPedidoJdbcTemplate.class);
		DaoClienteJdbcTemplate daoC = context.getBean("daoClienteJdbcTemplate",DaoClienteJdbcTemplate.class);
		
		daoP.crearTablaPedidos();
		daoC.crearTablaClientes();
		
		System.out.println("Se han creado las tablas");

	}

}
