package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Ordenador;

public class Main {
	
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Ordenador ordenador = context.getBean("ordenador",Ordenador.class);
		
		System.out.println("El precio de los componentes del ordenador es de "+String.format("%.2f", ordenador.calcularPrecioComponentes())+" €");

		
	}

}
