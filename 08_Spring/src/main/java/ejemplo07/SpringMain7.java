package ejemplo07;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain7 {
	public static ApplicationContext context = null;
		
	static {
		context = 
				new ClassPathXmlApplicationContext("ApplicationContext07.xml");
	}
	public static void main(String[] args) {
		List<String> listaNombres = 
				context.getBean("listaNombres",List.class);
		
		for(String s : listaNombres) {
			System.out.println(s);
		}
		
		System.out.println("*******************************************");
		List<Persona> listaPersonas = 
				context.getBean("listaPersonas",List.class);
		
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("*******************************************");
		Map<Integer,Persona> mapaPersonas = context.getBean("mapaPersonas",Map.class);
		
		mapaPersonas.forEach((k,v) ->{
			System.out.println("Key: "+k+" : Value: "+v);
		});
		
		System.out.println("*******************************************");
		Set<Persona> conjuntoPersonas = context.getBean("conjuntoPersonas",Set.class);
		
		conjuntoPersonas.forEach((v)->{
			System.out.println(v);
		});
		
		System.out.println("*******************************************");
		Colecciones colecciones = 
				context.getBean("colecciones",Colecciones.class);
		
		for(Persona p : colecciones.getListaPersonas()) {
			System.out.println(p.getNombre());
		}
		
		for(String s : colecciones.getConjuntoStrings()) {
			System.out.println(s);
		}
		
	/*	Map<Integer,Persona> mapaPersonas = 
				colecciones.getMapaPersonas();*/
		
		System.out.println(mapaPersonas.get(1).getNombre());
		System.out.println(mapaPersonas.get(2).getNombre());
	}
}
