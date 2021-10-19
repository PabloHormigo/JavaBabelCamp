package ejemplo09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBatalla {
		
	public static void main(String[] args) {
		
		//Con java debemos de instanciar los objetos
		Guerrero guerrero = new Guerrero();
		guerrero.setNombre("Aquiles");
		Espada espada = new Espada();
		espada.setTipo("larga");
		
		//inyectar la dependencia
		Arco arco = new Arco();
		arco.setTipo("largo");
		
		guerrero.setArma(arco);
		guerrero.atacar();
		

	}
}
