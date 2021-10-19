package ejemplo09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBattallaSpring {
	
	//arrrancamos nuestrro contenedor de objetos de spring
	private static ApplicationContext context = 
			new ClassPathXmlApplicationContext("beans09.xml");

	public static void main(String[] args) {
		
		//ahora con spring no tengo ninguna dependencia de esta clase con
		//la clase Espada y la clase Arco. 
		//De hecho no tengo ni dependencias debil con la clase abstracta Arma
		Guerrero guerrero2 = context.getBean("guerrero",Guerrero.class);
		guerrero2.atacar();
	}

}
