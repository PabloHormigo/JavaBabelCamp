package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoOrdenador;

public class Main {
	
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DaoOrdenador daoOrdenador = context.getBean("daoOrdenador",DaoOrdenador.class);
	
		daoOrdenador.generarFichero();

		
	}

}
