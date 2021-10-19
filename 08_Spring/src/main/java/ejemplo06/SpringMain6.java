package ejemplo06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain6 {
	public static ApplicationContext context = null;
		
	static {
		context = 
				new ClassPathXmlApplicationContext("ApplicationContext06.xml");
	}
	public static void main(String[] args) {
		Persona paco = context.getBean("persona",Persona.class);
		System.out.println(paco.getNombre());

		//Cuando le pedimos las personas prototipadas es cuando se ejecuta
		//el metodo de inicializacion
		Persona p1 = context.getBean("personaBean",Persona.class);
		Persona p2 = context.getBean("personaBean",Persona.class);
		System.out.println(p1);
		System.out.println(p2);
		
		
		System.out.println("************ DESTRUYENDO CONTEXTO ************");
		AbstractApplicationContext aac = 
				(AbstractApplicationContext)context;
		aac.close();
	}
}
