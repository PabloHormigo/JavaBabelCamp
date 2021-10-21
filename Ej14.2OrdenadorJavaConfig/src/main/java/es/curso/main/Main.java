package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfiguracionSpring;
import es.curso.dao.DaoOrdenador;

public class Main {
	
	public static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		DaoOrdenador daoOrdenador = context.getBean("daoOrdenador",DaoOrdenador.class);
		
		daoOrdenador.generarFichero();
		
	}

}
